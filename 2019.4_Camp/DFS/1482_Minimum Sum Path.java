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
     * @param root: the root
     * @return: minimum sum
     */
    public int minimumSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return root.val;
        }
        
        //若只有一个左子树或者右子树，不能直接取最小，因为最小是0 
        if (root.right == null) {
            return root.val + minimumSum(root.left);
        }
        if (root.left == null) {
            return root.val + minimumSum(root.right);
        }
        
        return root.val + Math.min(minimumSum(root.left), minimumSum(root.right));
    }
}
