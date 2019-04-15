public class Solution {
    /**
     * @param s1: a string
     * @param s2: a string
     * @return: is s1 and s2 are equivalent
     */
    public boolean isEquivalentStrings(String s1, String s2) {
        // Write your code here
        if (s1.equals(s2)) {
            return true;
        }
        
        if (s1.length() % 2 == 1) {
            return s1.equals(s2);
        }
        
        int len = s1.length() / 2;
        String a1 = s1.substring(0, len);
        String a2 = s1.substring(len);
        String b1 = s2.substring(0, len);
        String b2 = s2.substring(len);
        if (isEquivalentStrings(a1, b1) && isEquivalentStrings(a2, b2) || 
        isEquivalentStrings(a1, b2) && isEquivalentStrings(a2, b1)) {
            return true;
        }
        
        return false;
    }
}
