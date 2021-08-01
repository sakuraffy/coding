package top.sakuraffy.offer;

import java.util.*;

/**
 * @author: zhangqiushi
 * @create: 2021/07/26 10:37
 */
public class StringSolution {
    /**
     * 字符串全排列
     * @param str
     * @return
     */
    public String[] permutation(String str) {
        if (Objects.isNull(str) || str.length() == 0) {
            return new String[]{};
        }
        Set<String> result = new HashSet<>();
        doPermutation(str, "", result, new boolean[str.length()]);
        return result.toArray(new String[result.size()]);
    }

    /**
     * 字符串全排列
     * @param str
     * @param item
     * @param result
     * @param used
     */
    private void doPermutation(String str, String item, Set<String> result, boolean[] used) {
        if (item.length() == str.length()) {
            result.add(item);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                doPermutation(str, item + str.charAt(i), result, used);
                used[i] = false;
            }
        }
    }


    /**
     * 字符串是否能表示数字
     * @param str
     * @return
     */
    public boolean isNumber(String str) {
        return false;
    }

    /**
     * 最长不含重复字符的子字符串
     * @param str
     * @return
     */
    public int lengthOfLongestSubstring(String str) {
        return 0;
    }

    /**
     * 把数组排成最小的数
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return "";
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (s1, s2) -> ((s1 + s2).compareTo(s2 + s1)));
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    /**
     * 第一个只出现一次的字符
     * @param str
     * @return
     */
    public char firstUniqChar(String str) {
        if (Objects.isNull(str)) {
            return ' ';
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    /**
     * 左旋转字符串
     * @param str
     * @param n
     * @return
     */
    public String reverseLeftWords(String str, int n) {
        return null;
    }

    /**
     * 把字符串转换成整数
     * @param str
     * @return
     */
    public int strToInt(String str) {
        return 0;
    }

    /**
     *  正则表达式匹配
     * @param str
     * @param pattern
     * @return
     */
    public boolean isMatch(String str, String pattern) {
        return false;
    }

    /**
     * 数字序列中某一位的数字
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        return 0;
    }

    /**
     * 翻转单词顺序
     * @param str
     * @return
     */
    public String reverseWords(String str) {
        if (Objects.isNull(str) || str.length() == 0) {
            return "";
        }
        String[] strs = str.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (Objects.equals("", strs[i])) {
                continue;
            }
            sb.append(strs[i]).append(" ");
        }
        return sb.toString().trim();
    }

    /**
     * 替换空格
     * @param str
     * @return
     */
    public String replaceSpace(String str) {
        if (Objects.isNull(str)) {
            return null;
        }
        return str.replaceAll(" ", "%20");
    }
}
