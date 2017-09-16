public class Solution {
    /*
     * @param s: a string
     * @param t: a string
     * @return: true if the characters in s can be replaced to get t or false
     */
    public boolean isIsomorphic(String s, String t) {
        // write your code here
        if (s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (map.containsKey(cs)) {
                if (map.get(cs) != ct) {
                    return false;
                }
            } else {
                if (set.contains(ct)) {
                    return false;
                }
                map.put(cs, ct);
                set.add(ct);
            }
        }
        return true;
    }
}
