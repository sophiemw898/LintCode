/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    //如果树空，返回空。
    //如果root.val <= p.val，那么node的successor一定在树的右边。从root.right开始找。
    //如果root.val > p.val，那么successor一定在树的左边，或者是root本身。从root.left开始找，找得到返回值，找不到返回root。
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null || p == null) {
            return null;
        }
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }
    }
}
