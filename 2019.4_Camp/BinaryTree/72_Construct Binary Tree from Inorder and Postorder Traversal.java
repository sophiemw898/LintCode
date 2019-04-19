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
     * @param inorder: A list of integers that inorder traversal of a tree
     * @param postorder: A list of integers that postorder traversal of a tree
     * @return: Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        //根据当前后续序列的最后一个结点，在对应的中序遍历中找到位置，然后相同的方法，递归左右子树即可
        if (inorder.length != postorder.length) {
            return null;
        }
        
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode build(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        //corner case [] []
        if (instart > inend) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postend]);
        int index = findIndex(inorder, instart, inend, postorder[postend]);
        
        root.left = build(inorder, instart, index - 1, postorder, poststart, poststart + index - instart - 1);
        root.right = build(inorder, index + 1, inend, postorder, poststart + index - instart, postend - 1);
        
        return root;
    }
    
    private int findIndex(int[] order, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (order[i] == target) {
                return i;
            }
        }  
        return -1;
    }
}
