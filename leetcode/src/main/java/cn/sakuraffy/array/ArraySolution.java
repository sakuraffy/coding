package cn.sakuraffy.array;

/**
 * @author 数组相关解题
 * @author Sakuraffy
 * @date 2021/3/1 22:03
 */
public class ArraySolution {
    /**
     * desc: Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
     * That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
     * Return the answer in an array.
     *
     * solution: base counting sort.
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        // get the max value in array
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }

        int[] freq = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        int sum = 0;

        for (int i = 0; i < freq.length; i++) {
            int count = freq[i];
            freq[i] = sum;
            sum = sum + count;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = freq[nums[i]];
        }

        return nums;

    }
}
