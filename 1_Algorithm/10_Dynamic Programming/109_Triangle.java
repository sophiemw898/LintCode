//单独初始化
public class Solution {
    /*
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return 0;
        }
        
        int m = triangle.length;
        int[][] dp = new int [m][m];
        
        //initialization
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < m; i++){
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }
        
        //top dowm
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] =  Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }
        
        //answer
        int best = dp[m - 1][0];
        for (int i = 1; i < m; i++) {
            best = Math.min(best, dp[m - 1][i]);
        }
        return best;
    }
}

//循环内初始化
public class Solution {
    /*
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return 0;
        }
        
        int m = triangle.length;
        int[][] dp = new int [m][m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = triangle[i][j];
                } else if (i == j) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else if (i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                } else if (i > 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                }
                //System.out.print(dp[i][j] + " ");
            }
            
            //System.out.println("");
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            res = Math.min(res, dp[m - 1][i]);
        }
        
        return res;
    }
}
