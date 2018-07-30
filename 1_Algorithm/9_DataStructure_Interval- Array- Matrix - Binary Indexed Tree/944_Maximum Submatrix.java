//枚举子矩阵的上下边界 up & down 然后将这之间的数压缩为一个一维数组（降维攻击），剩下的任务就是一维数组如何求 Maximum Subarray 了。
//1. 用新矩阵prefixColSum[][] 存储每一列上前n行的和 
//  [[1,3,-1],[2,3,-2],[-1,-2,-3]]
//  [[0,0,0][1,3,-1],[3,6,-3],[2,4,-6]]
//2. 遍历矩阵的上下边界up& down， 通过prefixColSum[][] 将这之间的数压缩为一个一维数组（降维攻击）arr[]
//  prefixColSum[down + 1][i] - prefixColSum[up][i]
//3. 一维数组arr[] 如何求 Maximum Subarray,更新最大值即为up&down两行之间能找到的最大和矩阵

public class Solution {
    /**
     * @param matrix: the given matrix
     * @return: the largest possible sum
     */
     
    private int m, n;
    
    public int maxSubmatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        n = matrix.length;
        m = matrix[0].length;
        
        int[][] prefixColSum = new int[n + 1][m];
        
        prefixColSum = getPrefixColSum(matrix);
        
        int max = Integer.MIN_VALUE;
        for (int up = 0; up < n; up++) {
            for (int down = up; down < n; down++) {
                int[] arr = compression(matrix, up, down, prefixColSum);
                max = Math.max(max, maximumSubray(arr));
            }
        }
        
        return max;
    }
    
    private int[][] getPrefixColSum(int[][] matrix) {
        int[][] prefixColSum = new int[n + 1][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefixColSum[i + 1][j] = prefixColSum[i][j] + matrix[i][j];
                System.out.println(prefixColSum[i + 1][j]);
            }
        }
        return prefixColSum;
    }
    
    private int[] compression(int[][] matrix, int up, int down, int[][] prefixColSum) {
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = prefixColSum[down + 1][i] - prefixColSum[up][i];
        }
        return arr;
    }
    
    private int maximumSubray(int[] arr) {
        int min = 0, max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }
        return max;
    }
}
