import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _14 {

    //after checking discuss
    public int longestPalindrome3(String s) {
        int[] arr = new int[128];
        for (int i = 0; i < s.length(); i++) {
            arr[(int) s.charAt(i)]++;
        }
        int len = 0, omax = 0;
        for (int i = 0; i < 128; i++) {
            if (arr[i] % 2 == 0) len += arr[i];
            else {
                len += arr[i] - 1;
                omax = Math.max(omax, arr[i]);
            }
        }
        if (omax > 0) return len + 1;
        else return len;
    }

    //after checking discuss
    public int longestPalindrome2(String s) {
        Set<Character> set = new HashSet<>();
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                len += 2;
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        if (set.size() > 0) return len + 1;
        else return len;
    }

    //my original sol
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int len = 0, maxo = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if (count % 2 == 0) len += count;
            else {
                len += count - 1;
                maxo = Math.max(maxo, count);
            }
        }
        if (maxo > 0) len += 1;
        return len;
    }
}
