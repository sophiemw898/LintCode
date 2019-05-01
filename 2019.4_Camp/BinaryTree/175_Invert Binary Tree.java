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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        TreeNode temp = root.left;
        root.left = helper(root.right);
        root.right = helper(temp);
        
        return root;
    }
}

//BFS
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            TreeNode temp = new TreeNode(0);
            temp = node.left;
            node.left = node.right;
            node.right = temp;
            
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        } 
    }
}
