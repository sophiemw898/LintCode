//O(logn)
public class Solution {
    /*
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        } 
        
        boolean isNegitive = false;
        if (n < 0) {
            x = 1 / x;
            isNegitive = true;
            n = -(n + 1);
        }
        
        double res = 1;
        double temp = x;
        // for (int i = 0; i < n; i++) {
        //     res *= x;
        // } O(n)  超时！！！
        while (n > 0) {
            if (n % 2 == 1) {
                res *= temp;
            }
            temp *= temp;
            n = n / 2;
        }
        
        if (isNegitive) {
            res *= x;
        }
        
        return res;
    }
}     
