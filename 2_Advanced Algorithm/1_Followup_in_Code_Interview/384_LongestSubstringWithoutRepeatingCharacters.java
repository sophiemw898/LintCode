public class Solution {
    /*
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        while(s == null || s.length() == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        int ans = 1;
        for (i = 0; i < s.length(); i++) {
            while (j < s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                ans = Math.max(ans, j - i + 1);
                j++;
            }
            set.remove(s.charAt(i));
        }
        return ans;
    }
}

