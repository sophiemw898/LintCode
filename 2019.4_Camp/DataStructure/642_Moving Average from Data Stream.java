public class MovingAverage {
    /*
    * @param size: An integer
    */
    //use queue to relize 
    
    Queue<Integer> queue;
    int size;
    double sum = 0;
    
    public MovingAverage(int size) {
        // do intialization if necessary
        queue = new LinkedList<Integer>();
        this.size = size;
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        queue.offer(val);
        if (queue.size() <= size) {
            sum += val;
            return sum / queue.size();
        } else {
            sum = sum + val - queue.poll();
            return sum / size;
        }
    }
}
