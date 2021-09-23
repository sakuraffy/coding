package top.sakuraffy.base;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author: zhangqiushi
 * @create: 2021/08/03 15:00
 */
public class Sort {
    /**
     * 冒泡排序
     * @param nums
     * @return
     */
    public int[] bubbleSort(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return nums;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            boolean swapFlag = false;
            for (int j = 0; j < len - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swapFlag = true;
                }
            }
            if (!swapFlag) {
                break;
            }
        }
        return nums;
    }

    /**
     * 快速排序
     * @param nums
     * @return
     */
    public int[] quickSort(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 快速排序
     * @param nums
     * @param low
     * @param high
     */
    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pos = partition(nums, low, high);
            quickSort(nums, low, pos - 1);
            quickSort(nums, pos + 1, high);
        }
    }

    /**
     * 寻找中轴位置
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private int partition(int[] nums, int low, int high) {
        int temp = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= temp) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= temp) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }

    /**
     * 选择排序
     * @param nums
     * @return
     */
    public int[] selectSort(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return nums;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int minIdx = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[minIdx] > nums[j]) {
                    minIdx = j;
                }
            }
            swap(nums, minIdx, i);
        }
        return nums;
    }

    /**
     * 堆排序
     * @param nums
     * @return
     */
    public int[] heapSort(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return nums;
        }
        int len = nums.length;
        for (int i = (len - 1) / 2; i >= 0; i--) {
            adjustHeap(nums, i, len);
        }
        for (int i = len - 1; i >= 0; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
        return nums;
    }

    /**
     * 调整堆
     * @param nums
     * @param parent
     * @param length
     */
    private void adjustHeap(int[] nums, int parent, int length) {
        int child = 2 * parent + 1;
        int temp = nums[parent];
        while (child < length) {
            if (child + 1 < length && nums[child] < nums[child + 1]) {
                child++;
            }
            if (temp > nums[child]) {
                break;
            }
            nums[parent] = nums[child];
            parent = child;
            child = 2 * parent + 1;
        }
        nums[parent] = temp;
    }

    /**
     * 插入排序
     * @param nums
     * @return
     */
    public int[] insertSort(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return nums;
        }
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int j = i - 1, temp = nums[i];
            for (; j >= 0 && nums[j] > temp; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = temp;
        }
        return nums;
    }

    /**
     * 希尔排序
     * @param nums
     * @return
     */
    public int[] shellSort(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return nums;
        }
        int len = nums.length;
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                int j = i - gap, temp = nums[i];
                for (; j >= 0 && nums[j] > temp; j -= gap) {
                    nums[j + gap] = nums[j];
                }
                nums[j + gap] = temp;
            }
        }
        return nums;
    }

    /**
     * 归并排序
     * @param nums
     * @return
     */
    public int[] mergeSort(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return nums;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * 归并排序
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private int[] mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
        return nums;
    }

    /**
     * 合并两个有序数组
     * @param nums
     * @param low
     * @param mid
     * @param high
     */
    private void merge(int[] nums, int low, int mid, int high) {
        int[] arr = new int[high - low + 1];
        int i = low, j = mid + 1, idx = 0;
        while (i <= mid && j <= high) {
            arr[idx++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            arr[idx++] = nums[i++];
        }
        while (j <= high) {
            arr[idx++] = nums[j++];
        }
        for (i = 0; i < arr.length; i++) {
            nums[low + i] = arr[i];
        }
    }

    /**
     * 基数排序
     * @param nums
     * @return
     */
    public int[] radixSort(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return nums;
        }
        int bit = getMaxBit(nums);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < bit; i++) {
            int divisor = (int)Math.pow(10, i);
            for (int num : nums) {
                int idx = (num / divisor) % 10;
                List<Integer> list = map.getOrDefault(idx, new ArrayList<>());
                list.add(num);
                map.put(idx, list);
            }
            int idx = 0;
            for (int j = 0; j < 10; j++) {
                List<Integer> list = map.get(j);
                if (list != null) {
                    for (int num : list) {
                        nums[idx++] = num;
                    }
                    map.remove(j);
                }
            }
        }
        return nums;
    }

    /**
     * 计算数组最大位数
     * @param nums
     * @return
     */
    private int getMaxBit(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Integer.max(max, num);
        }
        int count = 0;
        while (max != 0) {
            max /= 10;
            count++;
        }
        return count;
    }

    /**
     * 交换数组两元素
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int len = nums.length;
        if (i < 0 || j < 0 || i >= len || j >= len) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}
