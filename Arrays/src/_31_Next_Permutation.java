import java.util.Arrays;

//Keep going left till the order is increasing
//When you reach a point where order decreases, stop
//Find the closest number larger than this on the right of this index and swap
//Sort right section of array to get next permutation
public class _31_Next_Permutation {
    public void nextPermutation(int[] nums) {
        int end = nums.length - 1;
        while (end > 0) {
            if (nums[end] > nums[end - 1]) {
                int minDiff = Integer.MAX_VALUE, j = -1;
                for (int i = end; i < nums.length; i++) {
                    if ((nums[i] > nums[end - 1]) && ((nums[i] - nums[end - 1]) <= minDiff)) {
                        minDiff = nums[i] - nums[end - 1];
                        j = i;
                    }
                }
                int tmp = nums[j];
                nums[j] = nums[end - 1];
                nums[end - 1] = tmp;
                Arrays.sort(nums, end, nums.length);
                return;
            }
            end--;
        }
        if (end == 0) {
            Arrays.sort(nums);
        }
    }
}
