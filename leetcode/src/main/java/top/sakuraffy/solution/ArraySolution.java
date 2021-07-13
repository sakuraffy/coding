package top.sakuraffy.solution;

import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.sakuraffy.solution.entity.TransactionEntity;

import java.util.*;

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

    public int[] avoidFlood(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        TreeSet<Integer> set = new TreeSet();
        int[] res = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            res[i] = 1;
            if (nums[i] == 0) {
                set.add(i);
                continue;
            }

            res[i] = -1;
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
                continue;
            }

            Integer idx = set.ceiling(map.get(nums[i]));
            if (idx == null) {
                return new int[]{};
            }

            res[idx] = nums[i];
            set.remove(idx);
            map.put(nums[i], i);
        }

        return res;
    }

    public int countPairs(int[] nums) {
        final int mod = 1_000_000_007;
        int[] twoSquare = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288,
                1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824};
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int square : twoSquare) {
                int target = square - nums[i];
                int count = map.getOrDefault(target, 0);
                ans = (ans + count) % mod;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return ans;
    }

    public int minSubarray(int[] nums, int p) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int mod = 0;
        for (int num : nums) {
            mod = (mod + num) % p;
        }
        if (mod == 0) {
            return 0;
        }
        Map<Integer, Integer> pos = new HashMap<>();
        pos.put(0, -1);
        int againMod = 0;
        int min = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            againMod = (againMod + nums[i]) % p;
            int comp = (p - mod + againMod) % p;
            if (pos.containsKey(comp)) {
                min = Math.min(min, i - pos.get(comp));
            }
            pos.put(againMod, i);
        }
        return min >= nums.length ? -1 : min;
    }

    public List<String> invalidTransactions(String[] transactions) {
        if (transactions == null || transactions.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<TransactionEntity>> map = new HashMap<>();
        for (String transaction : transactions) {
            String[] arr = transaction.split(",");
            List<TransactionEntity> list = map.getOrDefault(arr[0], new ArrayList<>());
            list.add(new TransactionEntity(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), arr[3]));
            map.put(arr[0], list);
        }

        List<String> res = new ArrayList<>();
        final int MAX_AMOUNT = 1_000;
        final int TIME_LIMIT = 60;
        for (List<TransactionEntity> list : map.values()) {
            list.sort(Comparator.comparingInt(TransactionEntity::getTime));
            int left = 0;
            int right = left + 1;

            while (left < right) {
                if (list.get(left).getAmount() > MAX_AMOUNT) {
                    if (!res.contains(list.get(left))) {
                        res.add(list.get(left).toString());
                    }
                }
                while (left < right && right < list.size() && list.get(right).getTime() - list.get(left).getTime() <= TIME_LIMIT) {
                    if (!list.get(right).getCity().equals(list.get(left).getCity())) {
                        if (!res.contains(list.get(left).toString())) {
                            res.add(list.get(left).toString());
                        }
                        if (!res.contains(list.get(right).toString())) {
                            res.add(list.get(right).toString());
                        }
                    }
                    right++;
                }
                right = Math.min(right + 1, list.size() - 1);
                left++;
            }
        }

        return res;
    }
}
