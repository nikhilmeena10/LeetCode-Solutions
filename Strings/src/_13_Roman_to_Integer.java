import java.util.HashMap;
import java.util.Map;

public class _13_Roman_to_Integer {

    public int romanToInt(String s) {
        if ((s == null) || (s.length() == 0)) return 0;
        Map<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        int sum = 0;
        sum += hm.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            char cc = s.charAt(i);
            char nc = s.charAt(i + 1);
            int cci = hm.get(cc);
            int nci = hm.get(nc);
            if (cci < nci) sum -= cci;
            else sum += cci;
        }
        return sum;
    }
    
}
