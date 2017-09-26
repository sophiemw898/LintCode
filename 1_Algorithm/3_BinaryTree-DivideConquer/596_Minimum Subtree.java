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
    /*
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    private TreeNode res = null;
    private int min = Integer.MAX_VALUE;
    public TreeNode findSubtree(TreeNode root) {
        // if (root == null || root.size() == 0) {
        //     return res;
        // }
        helper(root);
        return res;
    }
    
    //helper to return the sum of subtree
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //divide and conquer and merge
        int sum = root.val + helper(root.left) + helper(root.right);
        
        //traverse (compare with grobal variable)
        if (sum <= min) {
            min = sum;
            res = root;
        }
        return sum;
    }
}    
