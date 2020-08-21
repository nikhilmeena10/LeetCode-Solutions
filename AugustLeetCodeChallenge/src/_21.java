public class _21 {

    //not always recommended to modify in place, could use extra space
    public int[] sortArrayByParity(int[] a) {
        int len = a.length;
        int i = 0, j = len - 1;
        while (i < j) {
            while (i < len && a[i] % 2 == 0) {
                i++;
            }
            while (j >= 0 && a[j] % 2 != 0) {
                j--;
            }
            if (i >= j) break;
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++;
            j--;
        }
        return a;
    }

}
