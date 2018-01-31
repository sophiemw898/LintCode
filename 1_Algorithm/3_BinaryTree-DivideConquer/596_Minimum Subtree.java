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
// version 1 : traverse + divide conquer

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

//version 2: Pure divide conquer
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
    public TreeNode subtree;
    public int sum, minSum;
    public ResultType(TreeNode subtree, int sum, int minSum) {
        this.subtree = subtree;
        this.sum = sum;
        this.minSum = minSum;
    }
}

public class Solution {
    /*
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        return helper(root).subtree;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(null, 0, Integer.MAX_VALUE);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
    
        ResultType result = new ResultType(root, left.sum + right.sum + root.val, left.sum + right.sum + root.val);
   
        if (result.minSum >= left.minSum) {
            result.minSum = left.minSum;
            result.subtree = left.subtree;
        }
        if (result.minSum >= right.minSum) {
            result.minSum = right.minSum;
            result.subtree = right.subtree;
        }
        
        return result;
    }
}
