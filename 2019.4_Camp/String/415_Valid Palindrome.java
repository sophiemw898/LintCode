public class Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < s.length() && !isLetter(s.charAt(l))) {
                l++;
            }
            
            //corner case ".,,.//"
            if (l == s.length()) {
                return true;
            }
            
            while (r >= 0 && !isLetter(s.charAt(r))) {
                r--;
            }

            System.out.println(l);
            System.out.println(r);
            
            if (l <= r && Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                System.out.println(l);
                System.out.println(r);
                return false;
            }
            
            l++;
            r--;

        }
        
        return true;
    }
    
    private boolean isLetter (char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
