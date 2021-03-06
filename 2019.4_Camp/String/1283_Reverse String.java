public class Solution {
    /**
     * @param s: a string
     * @return: return a string
     */
    public String reverseString(String s) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        if (s == null || s.length() == 0) {
            return sb.toString();
        }
        
        for (int i = s.length() - 1; i >= 0; i--) { 
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}
