//DFS
public class Solution {
    /**
     * @param grid: an integer matrix
     * @return: an integer 
     */
    private int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int numIslandCities(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] isVisited = new boolean[n][m];
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j] && grid[i][j] != 0) {
                    ans += helper(grid, isVisited, i, j);
                }
            }
        }
        
        return ans;
    }
    //have city return 1, or 0
    private int helper(int[][] grid, boolean[][] isVisited, int x, int y) {
        isVisited[x][y] = true;
        int count = 0;
        
        if (grid[x][y] == 2) {
            count++;
        }
        
        for (int i = 0; i < 4; i++) {
            int x_adj = x + dir[i][0];
            int y_adj = y + dir[i][1];
            if (x_adj < 0 || x_adj >= grid.length || y_adj < 0 
            || y_adj >= grid[0].length || isVisited[x_adj][y_adj] 
            || grid[x_adj][y_adj] == 0) {
                continue;
            }
            count += helper(grid, isVisited, x_adj, y_adj);
        }
        
        if (count >= 1) {
            return 1;
        } else {
            return 0;
        }
    }
}
