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
     * @param head: a ListNode
     * @param k: An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        
        //D-1-2-3-4-5-6-7  k = 3
        //D- [3-2-1]-[6-5-4]-7;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        while (prev!= null) {
            prev = reverserNextKGroup(prev, k);
        }
        
        return dummy.next;
    }
    
    // head -> n1 -> n2 ... nk -> nk+1
    // =>
    // head -> nk -> nk-1 .. n1 -> nk+1
    // return n1
    private ListNode reverserNextKGroup(ListNode head, int k) {
        //find kth node nk nk+1
        ListNode curt = head;
        ListNode n1 = head.next;
        for (int i = 0; i < k; i++) {
            curt = curt.next;
            if (curt == null) {
                return null;
            }
        }
        ListNode nk = curt;
        ListNode nkplus = curt.next;
        
        //reverse
        ListNode prev = head;
        curt = n1;
        
        while (curt != nkplus) {
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }
        
        //connect
        head.next = nk;
        n1.next = nkplus;
        
        //return 下一组的前继节点 n1 
        return n1;
    }
}
