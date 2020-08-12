import java.util.ArrayList;
import java.util.List;

public class _12 {

    //after reading discuss, using ncr
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if (rowIndex == 0) return list;
        int num = rowIndex;
        int den = 1;
        long run = 1;
        for (int i = 1; i <= rowIndex; i++) {
            run *= num;
            run /= den;
            list.add((int) run);
            num--;
            den++;
        }
        return list;
    }

    //my sol
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if (rowIndex == 0) return list;
        list.add(1);
        if (rowIndex == 1) return list;
        List<Integer> list2 = new ArrayList<>();
        int curr = 2;
        while (curr <= rowIndex) {
            list2.add(1);
            for (int i = 0; i < list.size() - 1; i++) {
                list2.add(list.get(i) + list.get(i + 1));
            }
            list2.add(1);
            list = list2;
            list2 = new ArrayList<>();
            curr++;
        }
        return list;
    }

}
