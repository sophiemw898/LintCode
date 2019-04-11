public class Solution {
    /**
     * @param s: a string
     * @return: a string after capitalizes the first letter
     */
    public String capitalizesFirst(String s) {
        // Write your code here
        //corner case
        if (s == null || s.length() == 0) {
            return s;
        }
        
        char[] sentence = s.toCharArray();
    
        //Check the first letter
        if (sentence[0] >= 'a' && sentence[0] <= 'z') {
            sentence[0] = Character.toUpperCase(sentence[0]);
        }
        
        //Check all first letters after ' '
        for (int i = 1; i < s.length(); i++) {
            if (sentence[i - 1] == ' ' && Character.isLowerCase(sentence[i])) {
                sentence[i] = Character.toUpperCase(sentence[i]);
            }
        }
        
        return String.valueOf(sentence);
    }
}
