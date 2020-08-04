public class _4 {

    //discuss
    public boolean isPowerOfFour2(int num) {
        return num > 0 && ((num & (num - 1)) == 0) && ((num - 1) % 3 == 0);
    }

    //my Sol
    public boolean isPowerOfFour(int num) {
        int start = 1;
        while (start != 0 && start <= num) {
            System.out.println(start);
            if ((start & num) == num) return true;
            start <<= 2;
        }
        return false;
    }
}
