public class Solution {
    /**
     * @param dividend: the dividend
     * @param divisor: the divisor
     * @return: the result
     */
    public int divide(int dividend, int divisor) {
        //corner case
        if (divisor == 0) {
            return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        boolean isPositive = (dividend ^ divisor) >= 0;

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        
        int res = helper(a, b);
        return isPositive ? res : -res;
    }
    
    private int helper(long dividend, long divisor) {
        if (dividend < divisor) {    
            return 0;
        }
        
        int count = 1;
        long num = divisor;
        while (num + num < dividend) {
            num += num;
            count += count;
        }
        
        return count + helper(dividend - num, divisor);
    }
}
