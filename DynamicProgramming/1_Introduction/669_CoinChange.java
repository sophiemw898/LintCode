public class Solution {
    /*
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    public int coinChange(int[] coins, int amount) {
        // write your code here
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int k = 0; k < coins.length; k++) {
                if(i >= coins[k] && dp[i - coins[k]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[k]] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}
O(mn) coins*amount
