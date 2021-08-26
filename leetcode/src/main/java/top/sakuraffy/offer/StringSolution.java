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
        if (Objects.isNull(str) || str.trim().length() == 0) {
            return false;
        }
        str = str.trim();
        boolean pointCharacter = false;
        boolean eCharacter = false;
        for (int i = 0; i < str.length(); i++) {
           if (str.charAt(i) == '+' || str.charAt(i) == '-') {
               if (i + 1 < str.length() && (i == 0 || str.charAt(i - 1) == 'e' || str.charAt(i - 1) == 'E')) {
                   continue;
               }
               return false;
           }
           if (str.charAt(i) == '.') {
               if (!eCharacter && !pointCharacter && ((i > 0 && Character.isDigit(str.charAt(i - 1))) ||
                       (i + 1 < str.length() && Character.isDigit(str.charAt(i + 1))))) {
                   pointCharacter = true;
                   continue;
               }
               return false;
           }
            if (str.charAt(i) == 'e' || str.charAt(i) == 'E') {
                if (!eCharacter && i > 0 && (Character.isDigit(str.charAt(i - 1)) || str.charAt(i - 1) == '.')
                        && i + 1 < str.length()) {
                    eCharacter = true;
                    continue;
                }
                return false;
            }
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 最长不含重复字符的子字符串
     * @param str
     * @return
     */
    public int lengthOfLongestSubstring(String str) {
        if (Objects.isNull(str) || str.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, max = 0;
        while (j < str.length()) {
            while (j < str.length() && !map.containsKey(str.charAt(j))) {
                map.put(str.charAt(j), j);
                max = Math.max(j - i + 1, max);
                j++;
            }
            if (j < str.length() && map.containsKey(str.charAt(j))) {
                i = Math.max(i, map.get(str.charAt(j)) + 1);
                map.remove(str.charAt(j));
            }
        }
        return max;
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
        if (Objects.isNull(str) || str.length() <= 0 || n <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt((i + n) % str.length()));
        }
        return sb.toString();
    }

    /**
     * 把字符串转换成整数
     * @param str
     * @return
     */
    public int strToInt(String str) {
        if (Objects.isNull(str) || str.length() == 0) {
            return 0;
        }
        int base = 1;
        str = str.trim();
        long res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && str.charAt(i) == '+') {
                continue;
            }
            if (i == 0 && str.charAt(i) == '-') {
                base = -1;
                continue;
            }
            if (!Character.isDigit(str.charAt(i))) {
                return (int) res;
            }
            res = base * (Math.abs(res) * 10 + str.charAt(i) - '0');
            if (res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return (int)res;
    }

    /**
     *  正则表达式匹配
     * @param str
     * @param pattern
     * @return
     */
    public boolean isMatch(String str, String pattern) {
        if (Objects.isNull(str) || Objects.isNull(pattern)) {
            return false;
        }
        boolean[][] dp = new boolean[str.length() + 1][pattern.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= str.length(); i++) {
            for (int j = 1; j <= pattern.length(); j++) {
                if (pattern.charAt(j - 1) == '*') {
                    // * use 0
                    if (j - 2 >= 0) {
                        dp[i][j] |= dp[i][j - 2];
                    }
                    if (i > 0 && j > 1 && ((str.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.'))) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                } else {
                    if (i > 0 && (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.')) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[str.length()][pattern.length()];
    }

    /**
     * 数字序列中某一位的数字
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
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

    /**
     * 把数字翻译成字符串
     * @param num
     * @return
     */
    public int translateNum(int num) {
        if (num <= 0) {
            return 0;
        }
        String str = String.valueOf(num);
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= str.length(); ++i) {
            String pre = str.substring(i - 2, i);
            dp[i] = dp[i - 1];
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
               dp[i] += dp[i - 2];
            }
        }
        return dp[dp.length - 1];
    }
}
