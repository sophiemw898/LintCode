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
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        ListNode dummy = new ListNode(-1);
        ListNode lastNode;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            //dummy.next = null;
            lastNode = dummy;
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                lastNode.next = new ListNode(node.val);
                lastNode = lastNode.next;
                
                //System.out.println(lastNode);
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer (node.right);
                }
            }
            
            //lastNode.next = null;
            
            result.add(dummy.next);
        }
        
        return result;
    }
}
