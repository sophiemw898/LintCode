//dp O(n^2) time O(n^2) space
public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int n = s.length();
        int start = 0;
        int maxLength = 1;
        //dp[i][j] presents if subSting (i, j + 1) is palindromic
        boolean[][] dp = new boolean[n][n]; 
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            if (dp[i][i + 1] == true) {
                start = i;
                maxLength = 2;
            }
        }
        
        //注意运算顺序，必须从最下行开始添加 
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                // System.out.println(dp[i][j]);
                if (dp[i][j] == true && j - i + 1 > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }
        
        return s.substring(start, start + maxLength);
    }
}
