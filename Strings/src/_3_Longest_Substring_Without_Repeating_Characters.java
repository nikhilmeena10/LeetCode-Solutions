import java.util.HashMap;
import java.util.Map;

public class _3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if ((s == null) || (s.length() == 0)) {
            return 0;
        }
        int ans = 0;
        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (hm.containsKey(s.charAt(j))) {
                i = Math.max(i, hm.get(s.charAt(j)));
            }
            ans = Math.max(ans, j - i + 1);
            hm.put(s.charAt(j), j + 1);
        }
        return ans;
    }

}
