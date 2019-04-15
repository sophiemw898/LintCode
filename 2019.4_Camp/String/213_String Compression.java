public class Solution {
    /**
     * @param originalString: a string
     * @return: a compressed string
     */
    public String compress(String originalString) {
        // write your code here
        if (originalString == null || originalString.length() == 0) {
            return originalString;
        }
        
        StringBuilder sb = new StringBuilder();
        char ch = originalString.charAt(0);
        int count = 1;
        
        for (int i = 1; i < originalString.length(); i++) {
            if (originalString.charAt(i) == ch) {
                count++;
            } else {
                sb.append(ch);
                sb.append(count);
                ch = originalString.charAt(i);
                count = 1;
            }
        }
        //the last letter
        sb.append(ch);
        sb.append(count);
        
        return sb.toString().length() >= originalString.length() ? originalString : sb.toString();
    }
}
