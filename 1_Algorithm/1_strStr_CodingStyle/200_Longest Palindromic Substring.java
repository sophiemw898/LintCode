// 使用 Manancher's Algorithm，可以在 O(n) 的时间内解决问题 还没写
// 参考资料：https://www.felix021.com/blog/read.php?2040

//基于中心点枚举的算法，时间复杂度 O(n^2) 空间O（1）
public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        if (s == null && s.length() == 0) {
            return "";
        }
        
        int start = 0, maxLen = 0; 
        for (int i = 0; i < s.length(); i++) {
            int len1 = longestPalindromeFrom(s, i, i);
            int len2 = longestPalindromeFrom(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                start = i - (len - 1) / 2;//i present the central point
                maxLen = len;
            }
        }
        
        return s.substring(start, start + maxLen);
    }
    
    private int longestPalindromeFrom(String s, int i, int j) {
        int left = i, right = j;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        
        return right - left - 1;
    }
}

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
