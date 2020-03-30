public class _41_First_Missing_Positive {

    //Keep swapping
    //just look out for <=0, >n and duplicate numbers
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        if (nums.length == 1) {
            if (nums[0] == 1) return 2;
            else return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) return i + 1;
        }
        return nums.length + 1;
    }


    //Official Solution
    //Replace nos <=0 , >n with 1
    //Negate every number at nums[i] --> if a number exists, the value at its index will be negative, otherwise pos
    //understand case when missing number == len. Keep this at nums[0], the extra position we can use
    public int firstMissingPositiveOff(int[] nums) {
        int len = nums.length;
        int oneCount = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                oneCount++;
                break;
            }
        }
        //no 1s
        if (oneCount == 0) return 1;
        //1 is present but size of array is 1 --> [1]
        if (len == 1) return 2;

        //update nos <=0, >len
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < len; i++) {
            int a = Math.abs(nums[i]);
            if (a == len) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[a] = -Math.abs(nums[a]);
            }
        }
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        if (nums[0] > 0) {
            return len;
        }
        return len + 1;
    }

}
