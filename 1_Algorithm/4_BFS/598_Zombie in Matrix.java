class Coordinate {
    int x, y;
    public Coordinate (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    /**
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    public int PEOPLE = 0;
    public int ZOMBIE = 1;
    public int WALL = 2;
    public int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int zombie(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        //initialize the queue and count people 
        int people = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == PEOPLE) {
                    people++;
                } else if (grid[i][j] == ZOMBIE) {
                    queue.offer(new Coordinate(i, j));
                }
            }
        }
        
        //corner case
        if (people == 0) {
            return 0;
        }
        
        //bfs
        int days = 0;
        while (!queue.isEmpty()) {
            days++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate zombie = queue.poll();
                for (int[] dir : dirs) {
                    Coordinate adj = new Coordinate(zombie.x + dir[0], zombie.y + dir[1]);
                    if (isPeople(grid, adj.x, adj.y)) {
                        people--;
                        grid[adj.x][adj.y] = ZOMBIE;
                        queue.offer(adj);
                        if (people == 0) {
                            return days;
                        }
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean isPeople(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        return grid[x][y] == PEOPLE;
    }
}
