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
    public int sum, size;
    public ResultType(int sum, int size) {
        this.sum = sum;
        this.size = size;
    }
}

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    private TreeNode subtree = null;
    private ResultType subtreeResult = null;
     
    public TreeNode findSubtree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right == null && root.left == null) {
            return root;
        }
        
        helper(root);
        return subtree;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0,0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        ResultType result = new ResultType(root.val + left.sum + right.sum, left.size + right.size + 1);
        
        if (subtree == null || subtreeResult.sum * result.size < subtreeResult.size * result.sum) {
            subtree = root;
            subtreeResult = result;
        }
        
        return result;
    }
}
