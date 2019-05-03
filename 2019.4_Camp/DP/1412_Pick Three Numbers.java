public class Solution {
    /**
     * @param p: an integer
     * @param q: an integer
     * @param r: an integer
     * @param a: an array
     * @return: the maximum of p·a[i]+q·a[j]+r·a[k]
     */
    public long pickThreeNumbers(int p, int q, int r, int[] a) {
        //i枚举3个数字p,q,r。然后j枚举每个位置的数字，f[i][j]的最大值由Math.max(f[i-1][j] + a[j]* fac[i],f[i][j-1])转移而来。
        /*
            0           1           2           3       i
        0   p*a[0]         ......             Math.max(dp[0][i-1], p*a[i])
        1   dp[0][0] + q*a[0]
        2   dp[1][0] + r*a[0]
        
        
        for i: 1-2
            for j: 1-a.length
                dp[i][j] = max(dp[i][j - 1]  ......数组多一项没影响，a[i]没有用
                            dp[i-1][j] + r*a[j]......a[i]被使用)
        
        */
        
        long[][] dp = new long[3][a.length];
        int[] factor = {p, q, r};
        
        dp[0][0] = (long)p * a[0];
        dp[1][0] = dp[0][0] + (long)q * a[0];
        dp[2][0] = dp[1][0] + (long)r * a[0];
        
        for (int i = 1; i < a.length; i++) {
            dp[0][i] = Math.max(dp[0][i-1], (long)p * a[i]);
        }
        
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < a.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j] + (long)factor[i] * a[j]);
            }
        }
        
        return dp[2][a.length - 1];
    }
}
