//Easier Understanding
public class Solution {
    private int missingNum = -1; 
     
    public int findMissing2(int n, String str) {
        // write your code here
        if(n < 1 || str == null) {
            return -1;
        }
        
        dfs(n, str, 0, new boolean[n + 1], 0);
        
        return missingNum;
    }
    
    private void dfs(int n,             
                     String str, 
                     int startIndex,      // start index of each recursion
                     boolean[] visited,   // visited items
                     Integer count) {     // count of added numbers
        
        if(startIndex == str.length() && count == n - 1) {
            for(int i = 1; i < n + 1; i++) {
                if(!visited[i]) {
                    missingNum = i;
                    return;
                }
            }
            return;
        }
        
        for(int i = startIndex; i < startIndex + 2 && i < str.length(); i++) {
            
            String subString = str.substring(startIndex, i + 1);
            int num = Integer.parseInt(subString);
            
            if(num < 1 || num > n     // number should be valid
                || visited[num]       // number should not be visited
                || Integer.toString(num).length() != subString.length()) {  // Make sure the number doesn't start with 0    
                continue;
            }

            visited[num] = true;
            dfs(n, str, i + 1, visited, count + 1);
            visited[num] = false;
        }
    }
}


public class Solution {
    /**
     * @param n: An integer
     * @param str: a string with number from 1-n in random order and miss one number
     * @return: An integer
     */
    
    private int missingNum;
    
    public int findMissing2(int n, String str) {
        missingNum = -1;
        boolean[] isVisited = new boolean[n + 1];
        
        helper(n, str, isVisited, 0);
        return missingNum;
    }
    
    private void helper(int n, String str, boolean[] isVisited, int startIndex) {
        //already found answer
        if (missingNum != -1) {
            return;
        }
        
        //递归的出口 
        //finished the str and get the missing number
        if (startIndex == str.length()) {
            for (int i = 1; i <= n; i++) {
                if (!isVisited[i]) {
                    missingNum = i;
                    return;
                }
            }
            return;
        }
        
        // if first char is 0, the combination is not gonna work
        if (str.charAt(startIndex) == '0') {
            return;
        }
        
        //递归的拆解
        //check single & double chars separately
        for (int i = startIndex; i < startIndex + 2 && i < str.length(); i++) {
            int num = Integer.parseInt(str.substring(startIndex, i + 1));
            if (num == 0 || num > n || isVisited[num]) {
                continue;
            }
            
            isVisited[num] = true;
            helper(n, str, isVisited, i + 1);
            isVisited[num] = false;
        }
        // for (int ch = 1; ch <= 2 && startIndex + ch <= str.length(); ch++) {
        //     int num = Integer.parseInt(str.substring(startIndex, startIndex + ch));
        //     if (num > 0 && num <= n && !isVisited[num]) {
        //         isVisited[num] = true;
        //         helper(n, str, isVisited, startIndex + ch);
        //         isVisited[num] = false;
        //     }
        // }
    }
}
