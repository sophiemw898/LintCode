//最坏情况【1，2，3】【1，2，3】【1，2，3】 时间复杂度理论下线是O（M+N）
//为了达到理论下线，考虑到得是能不能用O（1）的时间排除一行或者一列 
public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        int count = 0;
        
        while (i < m && j >= 0) {
            if(matrix[i][j] == target) {
                i++;
                j--;
                count++;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return count;
    }
}
