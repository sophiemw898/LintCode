//采用分治法，时间复杂度 O(n)

public class Solution {
    /*
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    private boolean helper(TreeNode root, long maxValue, long minValue) {
        if (root == null) {
            return true;
        }
        
        if (root.val >= maxValue || root.val <= minValue) {
            return  false;
        }
        
        return helper(root.left, Math.min(root.val, maxValue), minValue) &&
                helper(root.right, maxValue, Math.max(root.val, minValue));
    }
}
