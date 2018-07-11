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
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        return helper(root, null, 0);
    }
    private int helper(TreeNode root, TreeNode parent, int lengthWithoutRoot) {
        if (root == null) {
            return 0;
        }
        int length = (parent != null && parent.val + 1 == root.val) ? lengthWithoutRoot + 1 : 1;
        int left = helper(root.left, root, length);
        int right = helper(root.right, root, length);
        
        return Math.max(length, Math.max(left, right));
    }
}


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
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    private int length;
    public int longestConsecutive(TreeNode root) {
        length = 0;
        helper(root);
        return length;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int maxSubtree = 1;// at least we have root 
        int left = helper(root.left);
        int right = helper(root.right);
        
        if (root.left != null && root.left.val == root.val + 1) {
            maxSubtree = Math.max(maxSubtree, left + 1);
        }
        if (root.right != null && root.right.val == root.val + 1) {
            maxSubtree = Math.max(maxSubtree, right + 1);
        }
        
        if (maxSubtree > length) {
            length = maxSubtree;
        }
        
        return maxSubtree;
    }
}
