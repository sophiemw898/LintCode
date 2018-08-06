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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        int newCapacity = 2 * hashTable.length;
        ListNode[] newTable = new ListNode[newCapacity];
        
        for (int i = 0; i < hashTable.length; i++) {
            while (hashTable[i] != null) {
                //C++/Java: if you directly calculate -4 % 3 you will get -1. You can use function: a % b = (a % b + b) % b to make it is a non negative integer.
                int newIndex = (hashTable[i].val % newCapacity + newCapacity) % newCapacity;
                if (newTable[newIndex] == null) {
                    newTable[newIndex] = new ListNode(hashTable[i].val);
                } else {
                    //新发现的点放在队尾
                    ListNode dummy = newTable[newIndex];
                    while (dummy.next != null) {
                        dummy = dummy.next;
                    }
                    dummy.next = new ListNode(hashTable[i].val);
                    //新发现的点放在队头
                        /* Input
                        [null,null,29->5->null]
                        Your stdout
                        [null,null,29->5->null]
                        Output
                        [null,null,null,null,null,5->29->null]
                        Expected
                        [null,null,null,null,null,29->5->null]
                        */
                    // ListNode dummy = newTable[newIndex];
                    // newTable[newIndex] = new ListNode(hashTable[i].val);
                    // newTable[newIndex].next = dummy;
                }
                hashTable[i] = hashTable[i].next;
            }
        }
        
        return newTable;
    }
};
