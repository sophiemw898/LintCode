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

//each subtree should be balances 
//the depth of the two subtrees of every node never differ by more than 1.
//two sides: isbalance? true or false && abs(dif_depth) <= 1
//transfer (isbalance? true or false) to is not balance == -1 
// public class Solution {
//     /*
//      * @param root: The root of binary tree.
//      * @return: True if this Binary tree is Balanced, or false.
//      */
//     private int NOT_BALANCE = -1;
//     public boolean isBalanced(TreeNode root) {
//         // write your code here
//         return maxDepth(root) != NOT_BALANCE;
//     }
    
//     private int maxDepth(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
//         int maxLeft = maxDepth(root.left);
//         int maxRight = maxDepth(root.right);
//         if (maxLeft == NOT_BALANCE || maxRight == NOT_BALANCE || Math.abs(maxLeft - maxRight) > 1) {
//             return NOT_BALANCE;
//         }
        
//         return Math.max(maxLeft, maxRight) + 1;
//     }
// }

//use ResultType Class to present two variables
class ResultType {
    public boolean isBalanced;
    public int depth;
    public ResultType(boolean isBalanced, int depth) {
        this.isBalanced = isBalanced;
        this.depth = depth;
    }
} 

public class Solution {
    /*
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType(false, -1);
        }
        if (Math.abs(left.depth - right.depth) > 1) {
            return new ResultType(false, -1);
        }
        
        return new ResultType(true, Math.max(left.depth, right.depth) + 1);
    }
}
