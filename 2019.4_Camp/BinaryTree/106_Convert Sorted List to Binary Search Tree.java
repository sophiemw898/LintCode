/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
    /*
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        //高度平衡，所以将链表从中间分开，左边是左子树，右边是右子树。
        //corner case
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        
        // 快慢指针找list中点
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        } 
        
        //slow为中点前一点
        ListNode rootNode = slow.next;
        //从slow之后断开链表
        slow.next = null;
        
        
        TreeNode root = new TreeNode(rootNode.val);
        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(rootNode.next);
        root.left = left;
        root.right = right;
        
        return root;
    }
}
