public class _17 {

    public int[] distributeCandies(int candies, int num_people) {
        long maxs = (int) ((-1 + Math.sqrt(1 + 8L * candies)) / 2);
        int rowc = (int) maxs / num_people;
        int fcells = rowc * num_people;
        int remc = (candies - ((fcells * (fcells + 1)) / 2));
        int[] arr = new int[num_people];
        for (int i = 0; i < num_people; i++) {
            arr[i] = (rowc * (2 * (i + 1) + (rowc - 1) * num_people)) / 2;
        }
        int start = fcells + 1;
        for (int i = 0; i < num_people; i++) {
            if (start <= remc) {
                arr[i] += start;
                remc -= start;
                start++;
            } else {
                arr[i] += remc;
                break;
            }
        }
        return arr;
    }

}
