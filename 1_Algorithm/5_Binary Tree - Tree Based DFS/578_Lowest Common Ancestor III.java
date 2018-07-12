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

class ResultType {
    public boolean a_exist, b_exist;
    public TreeNode node;
    public ResultType(boolean a_exist, boolean b_exist, TreeNode node) {
        this.a_exist = a_exist;
        this.b_exist = b_exist;
        this.node = node;
    }
}
public class Solution {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        ResultType rt = helper(root, A, B);
        if (rt.a_exist && rt.b_exist) {
            return rt.node;
        } else {
            return null;
        }
    }
    
    private ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ResultType(false, false, null);
        }
        
        ResultType left_rt = helper(root.left, A, B);
        ResultType right_rt = helper(root.right, A, B);
        
        boolean a_exist = left_rt.a_exist || right_rt.a_exist || A == root;
        boolean b_exist = left_rt.b_exist || right_rt.b_exist || B == root;
        
        if (A == root || B == root) {
            return new ResultType(a_exist, b_exist, root);
        }
        if (left_rt.node != null && right_rt.node != null) {
            return new ResultType(a_exist, b_exist, root);
        }
        
        // return (left_rt.node != null) ? new ResultType(a_exist, b_exist, left_rt.node) : new ResultType(a_exist, b_exist, right_rt.node);
        if (left_rt.node != null)
            return new ResultType(a_exist, b_exist, left_rt.node);
        if (right_rt.node != null)
            return new ResultType(a_exist, b_exist, right_rt.node);

        return new ResultType(a_exist, b_exist, null);
    }
}
