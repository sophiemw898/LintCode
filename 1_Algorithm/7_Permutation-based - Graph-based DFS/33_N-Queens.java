public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        //相当于那个数求排列，选取满足条件的排列
        List<List<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }
        
        helper(n, results, new ArrayList<Integer>());
        return results;
    }
    
    private void helper(int n, List<List<String>> results, List<Integer> cols) {
        if (cols.size() == n) {
            results.add(drawChessborad(cols));
            return;
        }
        
        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            helper(n, results, cols);
            cols.remove(cols.size() - 1);
        }
    }
    
    private List<String> drawChessborad(List<Integer> cols) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? "Q" : ".");
            }
            result.add(sb.toString());
        }
        
        return result;
    }
    
    private boolean isValid(List<Integer> cols, int colIndex) {
        int row = cols.size();//即将加入的点的横坐标
        for (int i = 0; i < row; i++) {
            //新加入的点colIndex没被访问过
            if (cols.get(i) == colIndex) {
                return false;
            }
            //斜角攻击 
            if (i + cols.get(i) == row + colIndex) {
                return false;
            }
            if (i - cols.get(i) == row - colIndex) {
                return false;
            }
        }

        return true;
    }
    //     private boolean isValid(List<Integer> cols, int column) {
    //     int row = cols.size();
    //     for (int rowIndex = 0; rowIndex < cols.size(); rowIndex++) {
    //         if (cols.get(rowIndex) == column) {
    //             return false;
    //         }
    //         if (rowIndex + cols.get(rowIndex) == row + column) {
    //             return false;
    //         }
    //         if (rowIndex - cols.get(rowIndex) == row - column) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}
