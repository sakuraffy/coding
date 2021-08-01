package top.sakuraffy.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhangqiushi
 * @create: 2021/07/21 20:50
 */
public class StringSolution {
    public int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int right = 0; right < str.length(); right++) {
            if (map.containsKey(str.charAt(right)) && map.get(str.charAt(right)) >= left) {
                left = map.get(str.charAt(right)) + 1;
            } else {
                max = Integer.max(max, right - left + 1);
            }
            map.put(str.charAt(right), right);
        }

        return max;
    }

    /**
     * 最长回文子串
     * @param str
     * @return
     */
    public String longestPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        String result = str.substring(0, 1);
        for (int i = 0; i < str.length(); i++) {
            for (int left = i - 1, right = i + 1; left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right); left--, right++) {
                if (result.length() < right - left + 1) {
                    result = str.substring(left, right + 1);
                }
            }

            for (int left = i, right = i + 1; left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right); left--, right++) {
                if (result.length() < right - left + 1) {
                    result = str.substring(left, right + 1);
                }
            }
        }

        return result;
    }

    public boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c)) {
                sb.append(Character.toUpperCase(c));
            }
        }

        str = sb.toString();

        for (int i = 0, j = str.length() - 1 ; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
