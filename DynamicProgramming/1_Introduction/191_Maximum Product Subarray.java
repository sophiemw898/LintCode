public class Solution {
    /*
     * @param nums: An array of integers
     * @return: An integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int[] mp = new int[nums.length];
        int ans = nums[0];
        dp[0] = nums[0];
        mp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], Math.max(dp[i - 1] * nums[i], mp[i - 1] * nums[i]));
            mp[i] = Math.min(nums[i], Math.min(dp[i - 1] * nums[i], mp[i - 1] * nums[i]));
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
o(n)
