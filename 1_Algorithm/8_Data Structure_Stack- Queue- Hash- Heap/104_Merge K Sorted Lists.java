//三种方法都是O（NlogK）
//version1 使用PriorityQueue Heap
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        int k = lists.size();
        PriorityQueue<ListNode> pq = new PriorityQueue<> (k, new Comparator<ListNode> () {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        
        for (ListNode n : lists) {
            if (n != null) {
                pq.offer(n);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode newHead = dummy;
        
        while (!pq.isEmpty()) {
            ListNode curt = pq.poll();
            newHead.next = curt;
            if (curt.next != null) {
                pq.offer(curt.next);
            }
            
            newHead = newHead.next;
        }
        
        return dummy.next;
    }
}

// Version 2: Divide & Conquer 类似归并排序的分制算法
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        return mergeHelper(lists, 0, lists.size() - 1);
    }   
    
    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }
        
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return merge(left, right);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        
        if (l2 != null) {
            head.next = l2;
        }
        if (l1 != null) {
            head.next = l1;
        }
        
        return dummy.next;
    }
}


// Version 3: 自底向上的两两归并算法merge two by two 12,34,56,78 -> 1.5 3.5, 5.5 7.5 -> 2.5 6.5 树高logK 每个数最多参与logk次合并 O（NlogK）
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        while (lists.size() > 1) {
            List<ListNode> new_lists = new ArrayList<>();
            for (int i = 0; i + 1 < lists.size(); i = i + 2) {
                ListNode curt = merge(lists.get(i), lists.get(i + 1));
                new_lists.add(curt);
            }
            if (lists.size() % 2 == 1) {
                new_lists.add(lists.get(lists.size() - 1));
            }
            
            lists = new_lists;
        }
        
        return lists.get(0);
    }   
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        
        if (l2 != null) {
            head.next = l2;
        }
        if (l1 != null) {
            head.next = l1;
        }
        
        return dummy.next;
    }
}
