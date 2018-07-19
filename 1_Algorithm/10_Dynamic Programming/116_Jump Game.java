public class Solution {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        boolean[] dp = new boolean[A.length];
        
        dp[0] =  true;
        
        for (int i = 1; i < A.length; i++) {
            dp[i] =  true;
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + A[j] >= i) {
                    dp[i] = true;
                    break;
                } else {
                    dp[i] = false;
                }
            }
        }
        
        return dp[A.length - 1];
    }
}

// Greedy
public class Solution {
    public boolean canJump(int[] A) {
        int farthest = A[0];
        
        for (int i = 1; i < A.length; i++) {
            if (i <= farthest && i + A[i] > farthest) {
                farthest = i + A[i];
            }
        }
        
        return farthest >= A.length - 1;
    }
}
