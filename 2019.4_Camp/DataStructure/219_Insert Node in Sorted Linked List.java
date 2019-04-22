/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: The head of linked list.
     * @param val: An integer.
     * @return: The head of new linked list.
     */
    public ListNode insertNode(ListNode head, int val) {
        //first try by myself
        // if (head == null) {
        //     head = new ListNode(val);
        //     return head;
        // }
        
        // if (head.val > val) {
        //     ListNode dummy = new ListNode(0);
        //     dummy.next = head;
        //     ListNode nod = new ListNode(val);
        //     nod.next = head;
        //     dummy.next = nod;
            
        //     return dummy.next;
        // }
        
        // ListNode node = head;
        // ListNode pre = null;
        // //find the last element <= val--- pre
        // while (node != null && node.val <= val) {
        //     pre = node;
        //     node = node.next;
        // }
        
        // pre.next = new ListNode(val);
        // pre.next.next = node;
        
        // return head;
        
        ListNode node = new ListNode(val);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        // find the last element <= val ----head
        while (head.next != null && head.next.val <= val) {
            head = head.next;
        }
        
        node.next = head.next;
        head.next = node;
        
        return dummy.next;
    }
}
