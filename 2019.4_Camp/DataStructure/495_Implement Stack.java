public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
    List<Integer> array = new ArrayList<>();
    
    public void push(int x) {
        array.add(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        int n = array.size();
        if (n > 0) {
            array.remove(n - 1);
        }
        return;
    }

    /*
     * @return: An integer
     */
    public int top() {
        return array.get(array.size() - 1);
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        return array.size() == 0;
    }
}
