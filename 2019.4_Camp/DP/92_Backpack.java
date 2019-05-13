public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        if (A == null) {
            return 0;
        }
        //f[i][j]表示前i个物品选一些物品正好放入容量为j的背包中能否放满。
        boolean[][] dp = new boolean[A.length + 1][m + 1];
        //initial
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = false;
            }
        }
        dp[0][0] = true;
        
        //recursion
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= A[i - 1] && dp[i - 1][j - A[i - 1]]) {
                    dp[i][j] = true;
                }
            }
        }
        
        for (int i = m; i >= 0; i--) {
            if (dp[A.length][i]) {
                return i;
            }
        }
        
        return 0;
    }
}
