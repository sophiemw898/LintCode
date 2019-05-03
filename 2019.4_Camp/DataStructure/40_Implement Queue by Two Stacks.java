//Push只进入stack1. 然后push或pop时检查stack2是否为空，不为空则直接返回第一个值，为空则把stack1的所有值挪到stack2中
public class MyQueue {
    
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    
    public MyQueue() {
        // do intialization if necessary
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
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
        if (stack2.isEmpty()) {
            stack1ToStack2();
        }
        return stack2.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        if (stack2.isEmpty()) {
            stack1ToStack2();
        }
        return stack2.peek();
    }
    
    private void stack1ToStack2() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}
