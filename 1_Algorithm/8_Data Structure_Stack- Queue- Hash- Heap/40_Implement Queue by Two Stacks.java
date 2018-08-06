public class MyQueue {
    
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    private void moveItem() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }
    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        stack1.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        if (stack2.empty()) {
            moveItem();
        }
        return stack2.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        if (stack2.empty()) {
            moveItem();
        }
        return stack2.peek();
    }
}
