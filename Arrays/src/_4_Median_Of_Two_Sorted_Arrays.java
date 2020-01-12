//https://www.youtube.com/watch?v=LPFhl65R7ww
public class _4_Median_Of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;

        int lo = 0;
        int hi = x;

        while (lo <= hi) {
            int partitionX = lo + (hi - lo) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int leftXMax = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int rightXMin = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int leftYMax = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int rightYMin = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if ((leftXMax <= rightYMin) && (leftYMax <= rightXMin)) {
                if ((x + y) % 2 == 0) {
                    return (Math.max(leftXMax, leftYMax) + Math.min(rightXMin, rightYMin)) / 2.0;
                } else {
                    return Math.max(leftXMax, leftYMax);
                }
            } else if (leftXMax > rightYMin) {
                hi = partitionX - 1;
            } else {
                lo = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }
}
