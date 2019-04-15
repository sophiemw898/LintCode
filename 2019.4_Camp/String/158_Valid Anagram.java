public class Solution {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] countS = new int[256];
        int[] countT = new int[256];
        //记录s中出现的字母及次数
        for (char c : s.toCharArray()) {
            countS[c]++;
        }
        //遍历t中出现的字母及次数
        for (char c : t.toCharArray()) {
            countT[c]++;
        }
        //查看次数是否相等
        for (int i = 0; i < 256; i++) {
            if (countT[i] != countS[i]) {
                return false;   
            }
        }
        
        return true;
    }
}
