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
    public boolean existA, existB;
    public TreeNode node;
    public ResultType(boolean a, boolean b, TreeNode node) {
        this.existA = a;
        this.existB = b;
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
        ResultType lca = helper(root, A, B);
        if (lca.existA && lca.existB) {
            return lca.node;
        } else {
            return null;
        }
    }
    
    private ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ResultType(false, false, null);
        }
        
        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);
        
        boolean existA = left.existA || right.existA || root == A;
        boolean existB = left.existB || right.existB || root == B;
        
        if (root == A || root == B) {
            return new ResultType(existA, existB, root);
        }
        if (left.node != null && right.node != null) {
            return new ResultType(existA, existB, root);
        }
        if (left.node != null) {
            return new ResultType(existA, existB, left.node);
        }
        if (right.node != null) {
            return new ResultType(existA, existB, right.node);
        }
        
        return new ResultType(existA, existB, null);
    }
}
