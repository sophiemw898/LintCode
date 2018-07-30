/*public class MovingAverage {
    private Queue<Integer> queue;
    private double sum = 0;
    private int size;

    // Initialize your data structure here. 
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
}*/

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param = obj.next(val);
 

//非滚动 
 public class MovingAverage {
    private double[] sum;
    private int size, id;

    // Initialize your data structure here. 
    public MovingAverage(int size) {
        id = 0;
        this.size = size;
        sum = new double[1000000];
    }
    
    public double next(int val) {
        // Write your code here
        id++;
        sum[id] =  sum[id - 1] + val;
        if (id > size) {
            return (sum[id] - sum[id - size]) / size;
        } else {
            return sum[id] / id;
        }
    }
}*/
//滚动 空间 O(size)
 public class MovingAverage {
    private double[] sum;
    private int size, id;

    // Initialize your data structure here. 
    public MovingAverage(int size) {
        id = 0;
        this.size = size;
        sum = new double[size + 1];
    }
    
    int mod(int x) {
        return x % (size + 1);
    }
    
    public double next(int val) {
        // Write your code here
        id++;
        sum[mod(id)] =  sum[mod(id - 1)] + val;
        if (id > size) {
            return (sum[mod(id)] - sum[mod(id - size)]) / size;
        } else {
            return sum[mod(id)] / id;
        }
    }
}
