public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
    private List<Integer> array;
    
    public Stack() {
        array = new ArrayList<>();
    }
     
    public void push(int x) {
        array.add(x);
    }

    public void pop() {
        int n = array.size();
        if (n > 0) {
            array.remove(n - 1);
        return;
    }

    public int top() {
        return array.get(array.size() - 1);
    }

    public boolean isEmpty() {
        return array.size() == 0;
    }
}
