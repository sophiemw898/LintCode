public class Solution {
    /**
     * @param s: 
     * @param str: 
     * @return: Output whether this combination meets the condition
     */
    public boolean checkWord(String s, String[] str) {
        // Write your code here
        //use set to record all different string in string
        Set<String> dict = new HashSet<>();
        for (String word : str) {
            dict.add(word);
        }
        //use hashmap to record if curt subword existes or not\
        Map<String, Boolean> map = new HashMap<>();
        
        return dfs(s, dict, map);
    }
    
    private boolean dfs(String s, Set<String> dict, Map<String, Boolean> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        
        //递归的出口
        if (!dict.contains(s)) {
            return false;
        }
        if (s.length() == 1) {
            return dict.contains(s);
        }
        
        for (int i = 0; i < s.length(); i++) {
            String nextWord = s.substring(0, i) + s.substring(i + 1);
            if (dfs(nextWord, dict, map)) {
                return true;
            }
            map.put(nextWord, false);
        }
        
        return false;
    }
}
