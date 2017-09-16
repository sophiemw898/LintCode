public class Solution {
    /*
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (k == 0) {
            return 0;
        }
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        for (i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                if (map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                } else {
                    if (map.size() == k) {
                        break;
                    }
                    map.put(s.charAt(j), 1);
                }
                j++;
            }
            ans = Math.max(ans, j - i);
            if (map.get(s.charAt(i)) > 1) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            } else {
                map.remove(s.charAt(i));
            }
        }
        return ans;
    }
}
