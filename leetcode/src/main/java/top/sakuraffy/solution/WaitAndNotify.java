package top.sakuraffy.solution;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class WaitAndNotify {
    // 记录还剩的产品数量
    public static final int EMPTY = 0;
    // 最大容纳量
    public static final int FULL = 50;
    // 锁对象
    public static Queue<Integer> queue = new ArrayBlockingQueue<>(FULL);

    public static final int THREAD_NUM = 5;

    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 40; i++) {
                try {
                    synchronized (queue) {
                        // 满了就不再生产
                        while (queue.size() >= FULL) {
                            try {
                                queue.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        queue.offer(i);
                        System.out.println(Thread.currentThread().getName() + " 生产 " + i + " 还剩 " + queue.size());
                        queue.notifyAll();
                        TimeUnit.MILLISECONDS.sleep((long)Math.random() * 1000);
                    }
                    // 避免一个线程生产或消费完
                    TimeUnit.MILLISECONDS.sleep((long)Math.random() * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 400; i++) {
                try {
                    synchronized (queue) {
                        // 空了就不再消费
                        while (queue.size() <= EMPTY) {
                            try {
                                queue.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(Thread.currentThread().getName() + " 消费 " + queue.poll() +  " 还剩 " + queue.size());
                        queue.notifyAll();
                        TimeUnit.MILLISECONDS.sleep((long)Math.random() * 1000);
                    }
                    // 避免一个线程生产或消费完
                    TimeUnit.MILLISECONDS.sleep((long)Math.random() * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        WaitAndNotify wan = new WaitAndNotify();
        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(wan.new Producer()).start();
            new Thread(wan.new Consumer()).start();
        }
    }
}
