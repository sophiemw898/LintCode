//O(s.length() * a.length)
//indexOf找出s所有可以被替换的位置i，用map<i,index> 存储s的替换位置i和该位置最长的可替换串a[index]。 
//最后遍历s根据map进行逐一替换，注意每替换完一个位置要跳过被替换的长度。
public class Solution {
    /**
     * @param a: The A array
     * @param b: The B array
     * @param s: The S string
     * @return: The answer
     */
    public String stringReplace(String[] a, String[] b, String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        Map<Integer, Integer> map = findReplaceIndex(s, a);
        StringBuilder sb = new StringBuilder(s);
        
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(i)) {
                int index = map.get(i);
                int len = b[index].length();
                sb.replace(i, i + len, b[index]);
                i = i + len - 1;
            }
        }
        
        return sb.toString();
    }
    
    //map of i->index
    //s[i] is replaceable by max(a[index].length())
    private Map<Integer, Integer> findReplaceIndex(String s, String[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < s.length(); j++) {
                int index = s.indexOf(a[i], j);
                if (index < 0) {
                    break;
                }
                if (!map.containsKey(index) || map.containsKey(index) && a[i].length() > a[map.get(index)].length()) {
                    map.put(index, i);
                }
                j = j + a[i].length() - 1;
            }
        }
        
        return map;
    }
}
