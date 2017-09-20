O (log n)

public class Solution {
    /*
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
     
     //Binary Search Once
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int start = 0;
        int end = r * c - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int i = mid / c;
            int j = mid % c;
            if (matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (matrix[start / c][start % c] == target) {
            return true;
        }
        if (matrix[end / c][end % c] == target) {
            return true;
        }
        return false;
    }
}

//Binary Search twice
public class Solution {
    /*
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
     
     //Binary Search Once
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int start = 0;
        int end = r  - 1;
        int row = 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                end = mid;
            } else if (matrix[mid][0] < target) {
                start = mid;
            }
        }
        
        //System.out.println(start);
        //System.out.println(end);
        
        if (matrix[end][0] <= target) {
            row = end;
        } else if (matrix[start][0] <= target) {
            row = start;
        } else {
            return false;
        }
        
        //System.out.println(row);
        
        int left = 0;
        int right = c - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (matrix[row][left] == target) {
            return true;
        }
        if (matrix[row][right] == target) {
            return true;
        }
        return false;
    }
}
