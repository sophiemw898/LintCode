/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
//Hashmap version.such as clone graph

public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        //copy node with node.label
        //pre.next = newnode; head = head.next; pre = newnode
        //copy node.random
        
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode prev = dummy; 
        RandomListNode newNode;// 1' 2'
        while (head != null) {
            if (map.containsKey(head)) {
                newNode = map.get((head));
            } else {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            prev.next = newNode;
            
            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    newNode.random = map.get(head.random);
                } else {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }
            head = head.next;
            prev = newNode;
        }
        
        return dummy.next;
    }
}
