import java.util.HashSet;
import java.util.Set;

public class _19 {
    public String toGoatLatin(String S) {
        String[] arr = S.split("\\s+");
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            char ch = s.charAt(0);
            if (set.contains(ch)) {
                sb.append(s);
                sb.append("ma");
            } else {
                sb.append(s.substring(1));
                sb.append(ch);
                sb.append("ma");
            }
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
