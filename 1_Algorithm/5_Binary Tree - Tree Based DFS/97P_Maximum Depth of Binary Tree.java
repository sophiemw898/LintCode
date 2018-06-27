public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }
}
