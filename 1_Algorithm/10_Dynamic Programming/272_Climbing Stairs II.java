//fewer code
public class Solution {
    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        
        for (int i = 1; i <= n;i++) {
            for (int j = 1; j <= 3; j++) {
                if (i >=j) {
                    dp[i] += dp[i - j];
                }
            }
        }
        // if (n > 0) {
        //     dp[1] = 1;
        // }
        // if (n > 1) {
        //     dp[2] = 2;
        // }
        // for (int i = 3; i <= n; i++) {
        //     dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        // }
        
        return dp[n];
    }
}

//1st myself

public class Solution {
    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        if (n > 0) {
            dp[1] = 1;
        }
        if (n > 1) {
            dp[2] = 2;
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        
        return dp[n];
    }
}
