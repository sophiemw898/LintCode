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
 
//divede conquer
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        
        return Math.max(maxLeft, maxRight) + 1;
    }
}

//traverse
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    private int maxDepth = 0;
    
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(1, root);
        return maxDepth;
    }
    
    private void helper(int depth, TreeNode root) {
        if (root == null) {
            return;
        }
        if (depth > maxDepth) {
            maxDepth = depth;
        }
        helper(depth + 1, root.left);
        helper(depth + 1, root.right);
    }
}
