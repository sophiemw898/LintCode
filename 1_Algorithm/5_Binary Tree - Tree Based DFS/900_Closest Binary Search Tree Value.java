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
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }
        
        // find the node with the smallest value that larger than or equal to target
        TreeNode upperNode = upperNode(root, target);
        // find the node with the largest value that smaller than target
        TreeNode lowerNode = lowerNode(root, target);
        
        if (upperNode == null) {
            return lowerNode.val;
        }
        if (lowerNode == null) {
            return upperNode.val;
        }
        
        return ((upperNode.val - target) > (target - lowerNode.val)) ? lowerNode.val : upperNode.val;
    }
    
    // find the node with the largest value that smaller than target
    private TreeNode lowerNode(TreeNode root, double target) {
        if (root == null) {
            return null;
        }
        if (root.val >= target) {
            return lowerNode(root.left, target);
        }
        
        //root.val < target
        TreeNode lowerNode = lowerNode(root.right, target);
        if (lowerNode != null) {
            return lowerNode;
        }
        
        return root;
    }
    
    // find the node with the smallest value that larger than or equal to target
    private TreeNode upperNode(TreeNode root, double target) {
        if (root == null) {
            return null;
        }
        if (root.val < target) {
            return upperNode(root.right, target);
        }
        
        //root.val >= target
        TreeNode upperNode = upperNode(root.left, target);
        if (upperNode != null) {
            return upperNode;
        }
        
        return root;
    }
}


