public class Solution {
    /**
     * @param A: A list of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        int[] dp = new int[A.length];
        //Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i < A.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        dp[0] = 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + A[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        
        return dp[A.length - 1];
    }
}
