O (log n)

     //Binary Search Once
public class Solution {
    /*
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;

        int start = 0;
        int end = row * col - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / col][mid % col] == target) {
                return true;
            } else if (matrix[mid / col][mid % col] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (matrix[start / col][start % col] == target) {
            return true;
        } else if (matrix[end / col][end % col] == target) {
            return true;
        } else {
            return false;
        }
    }
}

//Binary Search twice
public class Solution {
    /*
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;

        //find the row index, the last number <= target
        int start = 0;
        int end = row - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        System.out.println(start);
        System.out.println(end);
        
        if (matrix[end][0] <= target) {
            row = end;
        } else if (matrix[start][0] <= target) {
            row = start;
        } else {
            return false;
        }
        
        System.out.println(row);
        
        //find the column index, the number equal to target
        start = 0;
        end = col -1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (matrix[row][start] == target) {
            return true;
        } else if (matrix[row][end] == target) {
            return true;
        } else {
            return false;
        }
    }
}
