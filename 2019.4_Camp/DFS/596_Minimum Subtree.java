/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    private int minSum = Integer.MAX_VALUE;
    private TreeNode minNode = null;
    public TreeNode findSubtree(TreeNode root) {
        helper(root);
        return minNode;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int sum = left + right + root.val;
        
        if (sum < minSum) {
            minSum = sum;
            minNode = root;
        }
        
        return sum;
    }
}
