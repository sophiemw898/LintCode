public class Solution {
    /**
     * @param source: 
     * @param target: 
     * @return: return the index
     */
    public int strStr(String source, String target) {
        // Write your code here
        
        if (target.length() == 0) {
            return 0;
        }
        
        for (int i = 0; i < target.length(); i++) {
            for (int j = 0; j <= source.length() - target.length(); j++) {
                if (source.substring(j, j + target.length()).equals(target)) {
                    return j;
                }
            }
        }
        
        
        return -1;
    }
}
