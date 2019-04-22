class Node {
    public int val;
    public Node next;
    public Node(int x) {
        val = x;
        next = null;
    }
}


public class MyQueue {
    /*
     * @param item: An integer
     * @return: nothing
     */
     
    public Node first, last;
    
    public MyQueue() {
        first = last = null;
        // do initialize if necessary        
    }
    
    //last 用于enqueue
    //first用于dequeue
    public void enqueue(int item) {
        if (first == null) {
            //queue is empty
            last = new Node(item);
            first = last;
        } else {
            last.next = new Node(item);
            last = last.next;
        }
    }

    /*
     * @return: An integer
     */
    public int dequeue() {
        if (first != null) {
            int item = first.val;
            first = first.next;
            return item;
        }
        return -1;
    }
}
