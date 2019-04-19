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
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> inorder = new ArrayList<>();
        if (root == null) {
            return inorder;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        
        //node!= null 限制第一步
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node); 
                node = node.left;
            }
            node = stack.pop();
            inorder.add(node.val);
            node = node.right;
        }
        
        return inorder;
    }
}
