public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    //DFS, 利用isVisited[][]记录是否被用过，遍历board从word的第一个char开始找，找到即可return true。 注意边界条件，递归出口，以及释放isVisited. 
    public boolean exist(char[][] board, String word) {
        //corner case
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        // word ==  null;
        int m = board.length;
        int n = board[0].length;
        boolean[][] isVisited = new boolean[m][n];
        //System.out.println(isVisited[2][2]);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean res = helper(board, i, j, isVisited, word, 0);
                    if (res) {
                        return res;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean helper(char[][] board, int i, int j, boolean[][] isVisited, String word, int index) {
        //递归的终止
        if (index == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || isVisited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        isVisited[i][j] = true;
        if (helper(board, i + 1, j, isVisited, word, index + 1) ||
                        helper(board, i - 1, j, isVisited, word, index + 1) ||
                        helper(board, i, j + 1, isVisited, word, index + 1) ||
                        helper(board, i, j - 1, isVisited, word, index + 1)) {
            return true;
        }
        
        isVisited[i][j] = false;         
        return false;
    }
}
