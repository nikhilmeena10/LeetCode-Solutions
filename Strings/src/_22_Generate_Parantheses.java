import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _22_Generate_Parantheses {

    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<String>();
        if (n == 1) {
            List<String> list = new ArrayList<>();
            list.add("()");
            return list;
        }
        List<String> list = generateParenthesis(n - 1);
        Set<String> set = new HashSet<>();
        for (String s : list) {
            for (int i = 0; i < s.length(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.substring(0, i));
                sb.append("()");
                sb.append(s.substring(i));
                set.add(sb.toString());
            }
        }
        List<String> slist = new ArrayList<>();
        slist.addAll(set);
        return slist;
    }

}
