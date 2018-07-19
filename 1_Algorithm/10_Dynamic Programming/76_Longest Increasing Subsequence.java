//O(n^2)
public class Solution {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //present the longest increasing subsequence include i
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 0;
        
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;//initialization
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}
