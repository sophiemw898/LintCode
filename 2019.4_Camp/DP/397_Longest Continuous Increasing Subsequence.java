public class Solution {
    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int ans = 1;
        int[] lis = new int[A.length];
        int[] lds = new int[A.length];
        
        lis[0] = 1;
        lds[A.length - 1] = 1;
        
        for (int i = 1; i < A.length; i++) {
            lis[i] = 1;
            if (A[i] > A[i - 1]) {
                lis[i] = Math.max(lis[i - 1] + 1, lis[i]);
            }
            ans = Math.max(ans, lis[i]);
        }
        
        for (int i = A.length - 2; i >= 0; i--) {
            lds[i] = 1;
            if (A[i] > A[i + 1]) {
                lds[i] = Math.max(lds[i + 1] + 1, lds[i]);
            }
            ans = Math.max(ans, lds[i]);
        }
        
        return ans;
    }
}
