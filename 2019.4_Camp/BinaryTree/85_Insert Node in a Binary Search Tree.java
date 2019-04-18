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

//recursion
public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            return node;
        }
        
        if (root.val > node.val) {
            //go left
            root.left = insertNode(root.left, node); 
        } else {
            //go right
            root.right = insertNode(root.right, node);
        }
        
        return root;
    }
}

//iteration
public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            return node;
        }
        
        TreeNode cur = root;
        TreeNode prev = null;
        
        while (cur != null) {
            prev = cur;
            cur = cur.val > node.val ? cur.left : cur.right;
        }
        
        //此时cur = null停止循环 prev为node 的前继节点
        if (prev.val > node.val) {
            prev.left = node;
        } else {
            prev.right = node;
        }
        
        return root;
    }
}
