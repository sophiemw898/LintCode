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
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
     
    private TreeNode subtree;
    private int subtreeSum = Integer.MAX_VALUE;
     
    public TreeNode findSubtree(TreeNode root) {
        findSum(root);
        return subtree;
    }
    
    //fing the minimum sum of the subtree 
    private int findSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = findSum(root.left) + findSum(root.right) + root.val;
        if (sum < subtreeSum) {
            subtreeSum = sum;
            subtree = root;
        }
        
        return sum;
    }
}
