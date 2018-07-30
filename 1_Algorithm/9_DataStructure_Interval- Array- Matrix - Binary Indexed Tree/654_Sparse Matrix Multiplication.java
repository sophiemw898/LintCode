//进一步改进 hashmap
public class Solution {
    /**
     * @param A: a sparse matrix
     * @param B: a sparse matrix
     * @return: the result of A * B
     */
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int k = B[0].length;
        
        int[][] res = new int[m][k];
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        //将矩阵B中所有非0值的位置存入map
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
            for (int j = 0; j < k; j++) {
                if (B[i][j] != 0) {
                    map.get(i).add(j);
                }
            }
        }
        
        //A中为0 的点直接跳过，找A不为0 的点中与B非0 的点对应的值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0) {
                    continue;
                }
                for (int r = 0; r < map.get(j).size(); r++) {
                    int c = map.get(j).get(r);
                    res[i][c] += A[i][j] * B[j][c];
                }
            }
        }
        
        return res;
    }
}

public class Solution {
    /**
     * @param A: a sparse matrix
     * @param B: a sparse matrix
     * @return: the result of A * B
     */
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int k = B[0].length;
        
        int[][] res = new int[m][k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    for (int c = 0; c < k; c++)
                    res[i][c] += A[i][j] * B[j][c];
                }
            }
        }
        
        return res;
    }
}
