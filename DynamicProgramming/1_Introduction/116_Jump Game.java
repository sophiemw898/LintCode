public class Solution {
    /*
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        // write your code here
        boolean[] dp = new boolean[A.length];
        dp[0] = true;
        for (int j = 1; j < A.length; j++) {
            dp[j] = true;
            for (int i = 0; i < j; i++) {
                if (dp[i] && i + A[i] >= j) {
                    dp[j] = true;
                    break;
                }
                else {
                    dp[j] = false;
                }
            }
        }
        return dp[A.length - 1];
    }
}
O(n)
