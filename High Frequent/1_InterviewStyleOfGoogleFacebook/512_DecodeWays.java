public class Solution {
    /*
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // write your code here
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i-1) == '0') {
                if(s.charAt(i-2) == '1' || s.charAt(i-2) == '2') {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else {
                int num = 10 * Character.getNumericValue(s.charAt(i-2)) + Character.getNumericValue(s.charAt(i-1));
                if (num >= 11 && num <= 26) {
                    dp[i] =  dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[s.length()];
    }
}
