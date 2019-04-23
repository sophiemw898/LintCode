public class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if (x == 0) {
            return 0;
        }
        
        long X = (long)x;
        long start = 1, end = x;
        while (start + 1 < end) {
            long mid = start + (end - start)/2;
            if (mid * mid == X) {
                return (int)mid;
            } else if (mid * mid > X) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        return end * end <= X ? (int)end : (int)start;
    }
}
