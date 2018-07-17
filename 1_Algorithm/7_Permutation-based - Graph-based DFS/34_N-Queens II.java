//n-queen的改编版，就是把之前要打印出来的棋盘改成一个计数器。int[]创建一个对象，参与dfs，最后返回不同解的个数。
//为什么直接另sum是一个整数就传不进去 所有的输出都是0
public class Solution {
    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] sum = new int[]{0};
        
        helper(n, new ArrayList<Integer>(), sum);
        return sum[0];
    }
    
    private void helper(int n, List<Integer> cols, int[] sum) {
        if (cols.size() == n) {
            sum[0]++;
            return;
        }
        
        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            helper(n, cols, sum);
            cols.remove(cols.size() - 1);
        }
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
}


//在主函数中直接results.size().

public class Solution {
    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        //相当于那个数求排列，选取满足条件的排列
        List<List<String>> results = new ArrayList<>();
        // if (n <= 0) {
        //     return results;
        // }
        
        helper(n, results, new ArrayList<Integer>());
        return results.size();
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
}
