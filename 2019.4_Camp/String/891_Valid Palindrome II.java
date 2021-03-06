algorithm 1
 
public class Solution {
    /**
     * @param s: a string
     * @return boolean: whether you can make s a palindrome by deleting at most one character
     */
    public boolean validPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() <= 1) {
            return true;
        }
        
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left++;
            right--;
        }
        
        //此时已经全部遍历，则s本身就是palindrome
        if (left >= right) {
            return true;
        }
        
        return isPalindrome(s, left, right - 1) || isPalindrome(s, left + 1, right);
    }
    
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}




Algorithm 2
public class Solution {
    /**
     * @param s: a string
     * @return boolean: whether you can make s a palindrome by deleting at most one character
     */
    public boolean validPalindrome(String s) {
        // Write your code here
        if (isPalindrome(s)) {
            return true;
        }
        
        if (isPalindrome(s.substring(1))){
            return true;
        }
        
        if (isPalindrome(s.substring(0, s.length() - 1))) {
            return true;
        }
        
        for (int i = 1; i < s.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(0, i));
            sb.append(s.substring(i + 1, s.length()));
            System.out.println(sb.toString());
            return isPalindrome(sb.toString());
        }
        
        return false;
    }
    
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
