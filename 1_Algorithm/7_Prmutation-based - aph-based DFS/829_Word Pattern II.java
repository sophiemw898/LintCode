public class Solution {
    /**
     * @param pattern: a string,denote pattern string
     * @param str: a string, denote matching string
     * @return: a boolean
     */
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();//record pathern to Str
        Set<String> set = new HashSet<>();
        
        return dfs(pattern, str, map, set);
    }
        
    private boolean dfs(String pattern, String str, Map<Character, String> map, Set<String> set) 
        {
            if (pattern.length() == 0) {
                return str.length() == 0;
            }
            
            char c = pattern.charAt(0);
            //map中已存在c，继续判断是否一致
            if (map.containsKey(c)) {
                if (!str.startsWith(map.get(c))) {
                    return false;
                }
                return dfs(pattern.substring(1), str.substring(map.get(c).length()), map, set);
            }
            
            //map中不存在c，更新map
            for (int i = 0; i < str.length(); i++) {
                if (set.contains(str.substring(0, i + 1))) {
                    continue;
                }
                
                map.put(c, str.substring(0, i + 1));
                set.add(str.substring(0, i + 1));
                if (dfs(pattern.substring(1), str.substring(i + 1), map, set)) {
                    return true;
                }
                set.remove(str.substring(0, i + 1));
                map.remove(c);
            }
            
            return false;
        }
}
