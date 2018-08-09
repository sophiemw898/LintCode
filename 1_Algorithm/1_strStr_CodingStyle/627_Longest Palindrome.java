public class Solution {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        //use set to store lettle with odd times
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        
        int removeSize = set.size();
        if (removeSize > 0) {
            removeSize = removeSize - 1;
        }
        
        return s.length() - removeSize;   
    }
}
