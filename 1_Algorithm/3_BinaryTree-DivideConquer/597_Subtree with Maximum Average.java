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
     * @return: the root of the maximum average of subtree
     */
     
    private class ResultType {
        public int sum;
        public int size;
        public ResultType(int sum, int size) {
            this.sum = sum;
            this.size = size;
        }
    }
    
    private TreeNode res = null;
    private ResultType maxResult = null;
    
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        helper(root);
        return res;
    }
    //use helper to return sum and size of current node
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        ResultType rootResult = new ResultType(left.sum + right.sum + root.val, left.size + right.size + 1);
        
        if (res == null || maxResult.sum * rootResult.size < rootResult.sum * maxResult.size) {
            res = root;
            maxResult = rootResult;
        }
        //System.out.println(res);
        return rootResult;
    }
}
