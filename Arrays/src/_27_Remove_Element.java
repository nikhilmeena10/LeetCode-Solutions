public class _27_Remove_Element {
    public int removeElement(int[] nums, int val) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            while ((start < end) && (nums[start] != val)) {
                start++;
            }
            while ((start < end) && (nums[end] == val)) {
                end--;
            }
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) return i;
        }
        return nums.length;
    }
}
//Official solution:
/*
public int removeElement(int[] nums, int val) {
    int i = 0;
    int n = nums.length;
    while (i < n) {
        if (nums[i] == val) {
            nums[i] = nums[n - 1];
            // reduce array size by one
            n--;
        } else {
            i++;
        }
    }
    return n;
}
 */
