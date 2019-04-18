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
     * @param root: the root of the tree
     * @return: the total sum of all root-to-leaf numbers
     */
    public int sumNumbers(TreeNode root) {
        // write your code here\
        //需要记录上层节点传下来的值
        return helper(root, 0);
    }
    
    private int helper(TreeNode root, int prev) {
        if (root == null) {
            return 0;
        }
        int curt = prev * 10 + root.val;
        if (root.left == null && root.right == null) {
            return curt;
        }
        
        return helper(root.left, curt) + helper(root.right, curt);
    }
}
