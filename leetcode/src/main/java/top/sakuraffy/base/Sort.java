package top.sakuraffy.base;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * @author: zhangqiushi
 * @create: 2021/08/03 15:00
 */
public class Sort {
    public int[] bubbleSort(int[] nums) {
        return nums;
    }

    public int[] quickSort(int[] nums) {
        return nums;
    }

    public int[] selectSort(int[] nums) {
        return nums;
    }

    public int[] heapSort(int[] nums) {
        return nums;
    }

    public int[] insertSort(int[] nums) {
        return nums;
    }

    public int[] shellSort(int[] nums) {
        return nums;
    }

    public int[] mergeSort(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return nums;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int[] mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
        return nums;
    }

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

    public int[] radixSort(int[] nums) {
        return nums;
    }
}
