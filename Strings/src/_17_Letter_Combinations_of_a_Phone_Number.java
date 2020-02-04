import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_Letter_Combinations_of_a_Phone_Number {

    Map<Character, char[]> hm;
    boolean init;

    private void start() {
        hm = new HashMap<>();
        hm.put('2', new char[]{'a', 'b', 'c'});
        hm.put('3', new char[]{'d', 'e', 'f'});
        hm.put('4', new char[]{'g', 'h', 'i'});
        hm.put('5', new char[]{'j', 'k', 'l'});
        hm.put('6', new char[]{'m', 'n', 'o'});
        hm.put('7', new char[]{'p', 'q', 'r', 's'});
        hm.put('8', new char[]{'t', 'u', 'v'});
        hm.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        if ((digits == null) || (digits.length() == 0)) return new ArrayList<>();
        if (!init) {
            init = true;
            start();
        }
        if (digits.length() == 1) {
            List<String> list = new ArrayList<>();
            char[] arr = hm.get(digits.charAt(0));
            for (char c : arr) {
                list.add(c + "");
            }
            return list;
        }
        char[] arr = hm.get(digits.charAt(0));
        List<String> list = letterCombinations(digits.substring(1));
        List<String> slist = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (String s : list) {
                slist.add(arr[i] + s);
            }
        }
        return slist;
    }

}
