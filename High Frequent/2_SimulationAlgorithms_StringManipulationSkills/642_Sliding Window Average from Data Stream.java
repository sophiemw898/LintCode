public class MovingAverage {
    private Queue<Integer> queue;
    private double sum = 0;
    private int size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }
    
    public double next(int val) {
        // Write your code here
        sum += val;
        queue.offer(val);
        if (queue.size() > size) {
            sum = sum - queue.poll();
        }
        double ans = sum / queue.size();
        return ans;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param = obj.next(val);
 */
