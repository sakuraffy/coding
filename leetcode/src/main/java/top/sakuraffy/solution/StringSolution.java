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
}
