package top.sakuraffy.bean.same;

import java.util.*;

/**
 * @program: coding
 * @description: 数之和
 * @author: zhangqiushi
 * @create: 2021/05/29 21:22
 */
public class NumberSum {
    /**
     * 找出一组两数之和为目标数
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }

    /**
     * 找出所有三数之和为0的组合
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);
        // Two Point
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                    while(left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                    while(left < right && nums[right + 1] == nums[right]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }

    /**
     * 寻找三数之和与目标数最接近的数
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = 0;
        // Two Point, 从中间向两边寻找平均速度会快一点点
        for (int i = 1; i < nums.length - 1; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < nums.length) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(target - sum) < diff) {
                    diff = Math.abs(target - sum);
                    res = sum;
                }
                if (sum < target) {
                    right++;
                } else {
                    left--;
                }
            }
        }

        return res;
    }

    /**
     * 三数之和为目标数的组合数
     * @param nums
     * @param target
     * @return
     */
    public int threeSumMulti(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;
        final int mod = 1_000_000_007;
        for (int i = 0; i < nums.length; i++) {
            res = (res + map.getOrDefault(target - nums[i], 0)) % mod;

            for (int j = 0; j < i; j++) {
                int temp = nums[i] + nums[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        return res;
    }

    /**
     * 寻找与目标值相同的所有四数之和组合
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);
        // Two Point
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length -2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left++], nums[right--]));
                        while(left < right && nums[left - 1] == nums[left]) {
                            left++;
                        }
                        while(left < right && nums[right + 1] == nums[right]) {
                            right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return res;
    }

    /**
     * 四数和为0的组合数
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        if (nums1 == null || nums2 == null || nums3 ==  null || nums4 == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                map.put(nums1[i] + nums2[j], map.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }

        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int num = map.getOrDefault(0 - (nums3[i] + nums4[j]), 0);
                res += num;
            }
        }

        return res;
    }
}
