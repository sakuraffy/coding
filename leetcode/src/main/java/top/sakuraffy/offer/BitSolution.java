package top.sakuraffy.offer;

import java.util.Objects;

/**
 * @author: zhangqiushi
 * @create: 2021/07/26 11:35
 */
public class BitSolution {
    /**
     * 1~n求和
     * @param n
     * @return
     */
    public int sumNums(int n) {
        return 0;
    }

    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 0; i < bits.length; i++) {
                bits[i] += num & 1;
                num >>>= 1;
            }
        }
        int result = 0;
        for (int i = 0; i < bits.length; i++) {
            result <<= 1;
            result |= bits[31 - i] % 3;
        }
        return result;
    }

    /**
     * 二进制中1的个数
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            n = n & (n - 1);
            result++;
        }
        return result;
    }

    /**
     * 1～n 整数中 1 出现的次数
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        int high = n, i = 1, total = 0;
        while (high > 0) {
            high = n / (int)Math.pow(10, i);
            int temp = n % (int)Math.pow(10, i);
            int curr = temp / (int)Math.pow(10, i - 1);
            int low = temp % (int)Math.pow(10, i - 1);
            if (curr < 1) {
                total += high * Math.pow(10, i - 1);
            } else if (curr == 1) {
                total += high * Math.pow(10, i - 1) + low + 1;
            } else {
                total += (high + 1) * Math.pow(10, i - 1);
            }
            i++;
        }
        return total;
    }

    /**
     * 不用加减乘除做加法
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        return 0;
    }

    /**
     * 数值的整数次方
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (n % 2 == 0) {
            double temp = myPow(x, n / 2);
            return temp * temp;
        } else {
            double temp = myPow(x, (n - 1) / 2);
            return x * temp * temp;
        }
    }

    /**
     * 数组中找出两个只出现一次的数字
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 2) {
            return new int[]{};
        }
        int xOrResult = 0;
        for (int num : nums) {
            xOrResult ^= num;
        }
        int diff = 1;
        while ((diff & xOrResult) == 0) {
            diff <<= 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & diff) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
