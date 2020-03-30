public class _268_Missing_Number {

    //My solution
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int extra = len;
        int wsum = 0;
        boolean wflag = false;
        for (int i = 0; i < len; i++) {
            wsum += nums[i];
            if (nums[i] >= len) {
                extra = nums[i];
                wflag = true;
            }
        }
        if (!wflag) return len;
        int csum = ((len - 1) * len) / 2;
        int ans = csum - (wsum - extra);
        return ans;
    }

    //xor solution
    //apparently extra number is always n
    public int missingNumberXOR(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ i ^ nums[i];
        }
        ans ^= nums.length;
        return ans;
    }

}
