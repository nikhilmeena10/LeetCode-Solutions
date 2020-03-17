public class _108_Convert_Sorted_Array_to_Binary_Tree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return getSubTree(nums, 0, nums.length - 1);
    }

    private TreeNode getSubTree(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getSubTree(nums, start, mid - 1);
        root.right = getSubTree(nums, mid + 1, end);
        return root;
    }

}
