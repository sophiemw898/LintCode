public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        //记录当前点之前的最小值，不断更新maxPro
        int ans = 0;
        int[] dp = new int[prices.length];
        
        dp[0] = 0;
        dp[1] = prices[0];
        ans = Math.max(ans, prices[1] - dp[1]);
        for (int i = 2; i < prices.length; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i - 1]);
            ans = Math.max(ans, prices[i] - dp[i]);
        }
        
        return ans;
    }
}
