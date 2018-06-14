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
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stackFromLeft = new Stack<>();
        Stack<TreeNode> stackFromRight = new Stack<>();
        
        stackFromLeft.add(root);
        boolean fromLeft = true;
        
        List<Integer> cur = new ArrayList<>();
        
        while (!stackFromLeft.isEmpty() ||!stackFromRight.isEmpty()) {
            // List<Integer> cur = new ArrayList<>();
            if (fromLeft) {
                TreeNode node = stackFromLeft.pop();
                cur.add(node.val);
                if (node.left != null) {
                    stackFromRight.add(node.left);
                }
                if (node.right != null) {
                    stackFromRight.add(node.right);
                }
                if (stackFromLeft.isEmpty()) {
                    result.add(cur);
                    fromLeft = false;
                    cur = new ArrayList<>();
                }
            } else {
                TreeNode node = stackFromRight.pop();
                cur.add(node.val);
                if (node.right != null) {
                    stackFromLeft.add(node.right);
                }if (node.left != null) {
                    stackFromLeft.add(node.left);
                }
                if (stackFromRight.isEmpty()) {
                    result.add(cur);
                    fromLeft = true;
                    cur = new ArrayList<>();
                }
            }
        }
        return result;
    }
}
