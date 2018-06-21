// new class to show coordinate
class Coordinate {
    int x, y;
    public Coordinate (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
     
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    bfs(grid, i, j);
                    count++; 
                }
            }
        }
        
        return count;
    }
    
    private void bfs(boolean[][] grid, int x, int y) {
        Queue<Coordinate> queue = new LinkedList<>();
        
        queue.offer(new Coordinate(x, y));
        grid[x][y] = false;
        
        while (!queue.isEmpty()) {
            Coordinate coor = queue.poll();
            for (int[] dir : dirs) {
                Coordinate adj = new Coordinate(coor.x + dir[0], coor.y + dir[1]); 
                
                if (adj.x >= 0 && adj.x < grid.length && adj.y >= 0 && adj.y < grid[0].length && grid[adj.x][adj.y]) {
                    grid[adj.x][adj.y] = false;
                    queue.offer(adj);
                }
            }
        }
    }
}

// use int[] array to present coordinate
public class Solution {
    /*
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(boolean[][] grid) {
        if (grid == null | grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    res++;
                    queue.offer(new int[] {i, j});
                    while (!queue.isEmpty()) {
                        int[] cood = queue.poll();
                        for (int[] d : dirs) {
                            int x = d[0] + cood[0];
                            int y = d[1] + cood[1];
                            if (x >= 0 && x < n && y >= 0 && y < m &&
                                    grid[x][y]) {
                                grid[x][y] = false;
                                queue.offer(new int[] {x, y});
                            }
                        }
                    }
                }
            }
        }
        
        return res;
    }
}
