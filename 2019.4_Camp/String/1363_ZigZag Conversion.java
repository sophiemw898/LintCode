public class Solution {
    /**
     * @param s: the given string
     * @param numRows: the number of rows
     * @return: the string read line by line
     */
    public String convert(String s, int numRows) {
        // Write your code here
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        
        String res = "";
        int interval = numRows + numRows - 2;
        
        //combine all rows together
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += interval) {
                res += s.charAt(j);
                //the last two limitation is for first and last rows
                if (j + (interval - 2 * i) < s.length() 
                    && interval - 2 * i > 0
                    && interval - 2 * i < interval) {
                    res += s.charAt(j + (interval - 2 * i) );
                }
            }
        }
      
        return res;
        
        
        // //first row
        // for (int i = 0; i < s.length(); i += interval) {
        //     res += s.charAt(i);
        // }
        
        // //middle part
        // for (int i = 1; i < numRows - 1; i++) {
        //     for (int j = i; j < s.length(); j += interval) {
        //         res += s.charAt(j);
        //         if (j + (interval - 2 * i) < s.length()) {
        //             res += s.charAt(j + (interval - 2 * i) );
        //         }
        //     }
        // }
        
        // //last row
        // for (int i = numRows - 1; i < s.length(); i += interval) {
        //     res += s.charAt(i);
        // }
     
    }
}
