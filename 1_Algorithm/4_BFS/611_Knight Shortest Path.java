/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    public int[][] dirs = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, 
                            {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
    
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        int steps = 0;
        grid[source.x][source.y] = true;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                if (point.x == destination.x && point.y == destination.y) {
                    return steps;
                }
                for (int[] dir : dirs) {
                    Point adj = new Point(point.x + dir[0], point.y + dir[1]);
                    if (isValid(grid, adj.x, adj.y)) {
                        // mark the point not accessible
                        grid[adj.x][adj.y] = true;
                        queue.offer(adj);
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
    
    private boolean isValid(boolean[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        return (grid[x][y] == false);
    }
}
