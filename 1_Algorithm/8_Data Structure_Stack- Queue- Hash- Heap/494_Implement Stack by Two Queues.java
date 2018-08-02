// version2 : 只在queue1中存储，queue2用来颠倒顺利

public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    
    public Stack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }
    
    private void moveItems() {
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
    }
    
    private void swapQueues() {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public void push(int x) {
        queue1.offer(x);
    }
    
    public void pop() {
        moveItems();
        queue1.poll();
        swapQueues();
    }

    public int top() {
        moveItems();
        int res = queue1.poll();
        swapQueues();
        queue1.offer(res);
        
        return res;
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}

// version1: 两个queue循环使用 
public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int size;
    
    public Stack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        size = 0;
    }
    // Push element x onto stack.
    public void push(int x) {
        if (queue1.isEmpty()) {
            queue2.offer(x);
        } else {
            queue1.offer(x);
        }
        size++;
    }
    // Removes the element on top of the stack.
    public void pop() {
        if (size == 0) {
            return;
        }
        int res;
        // 将前面的数都offer进另一个队列，然后拿出最后一个数
        if (queue1.isEmpty()) {
            for(int i = 0; i < size - 1; i++) {
                queue1.offer(queue2.poll());
            }
            res = queue2.poll();
        } else {
            for(int i = 0; i < size - 1; i++) {
                queue2.offer(queue1.poll());
            }
            res = queue1.poll();
        }
        size--;
    }

    public int top() {
        if (size == 0) {
            return -1;
        }
                int res;
        // 将前面的数都offer进另一个队列，然后拿出最后一个数
        if (queue1.isEmpty()) {
            for(int i = 0; i < size - 1; i++) {
                queue1.offer(queue2.poll());
            }
            res = queue2.poll();
        } else {
            for(int i = 0; i < size - 1; i++) {
                queue2.offer(queue1.poll());
            }
            res = queue1.poll();
        }
        
        if (queue1.isEmpty()) {
            queue2.offer(res);
        } else {
            queue1.offer(res);
        }
        
        return res;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
