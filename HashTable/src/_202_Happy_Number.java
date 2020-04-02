import java.util.HashSet;
import java.util.Set;

public class _202_Happy_Number {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            n = sumOfSquaresOfDigits(n);
        }
        return n == 1;
    }

    private int sumOfSquaresOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }

}
