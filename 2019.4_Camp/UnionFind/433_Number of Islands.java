//封装unionfind的类 almost O(n)
class UnionFind {
    private int[] father = null;
    private int count;
    private int find (int x) {
        if (father[x] == x) {
            return x;
        } 
        return father[x] = find(father[x]);
    }
    
    public UnionFind (int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
    
    public void connect (int a, int b) {
        int fatherA = find(a);
        int fatherB = find(b);
        if (fatherB != fatherA) {
            father[fatherA] = fatherB;
            count--;//use to calculate the res = total -- each time
        }
    }
    
    public int query() {
        return count;
    }
    
    public void setCount(int cnt) {
        count = cnt;
    }
}

//grid[i][j] i j  (i - 1) cols + j

public class Solution {
    public int numIslands(boolean[][] grid) {
        int cnt = 0;
        
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int n = grid.length;
        int m = grid[0].length;

        //have m*n elements, transfer to array linear
        UnionFind union_find = new UnionFind(m * n);
        //count all 1s
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    cnt++;
                }
            }
        }
        union_find.setCount(cnt);
        
        //if connect once count-- then get res
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    if (i > 0 && grid[i -1][j]) {
                        union_find.connect((i * m + j), ((i - 1) * m + j));
                    }
                    if (i < n - 1 && grid[i + 1][j]) {
                        union_find.connect((i * m + j), ((i + 1) * m + j));
                    }
                    if (j > 0 && grid[i][j - 1]) {
                        union_find.connect((i * m + j), (i * m + j - 1));
                    }
                    if (j < m - 1 && grid[i][j + 1]) {
                        union_find.connect((i * m + j), (i* m + j + 1));
                    }
                }
            }
        }
        
        return union_find.query();
    }
}
