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
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        ListNode dummy = new ListNode(0);
        System.out.println(dummy.val);
        // 这个dummy的作用是，把head开头的链表一个个的插入到dummy开头的链表里
        // 所以这里不需要dummy.next = head;

        while (head != null) {
            //每次更新head后，从dummy开始最后一个小于head的点 之后插入head            ListNode node = dummy;
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            
            //在dummy开头的链表里插入head，在原链表里删除head
            //0-1-null
            //3-2-0-null  then
            //0-1-3-null
            //2-0-null
            
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }
        
        return dummy.next;
    }
}
