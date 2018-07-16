public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String, ArrayList<String>> map =  new HashMap<>();
        return dfs(s, wordDict, map);
    }
    
    private List<String> dfs(String s, Set<String> wordDict, Map<String, ArrayList<String>> map) {
        //递归的出口
        if (map.containsKey(s)) {
            return map.get(s);
        }
        
        ArrayList<String> result = new ArrayList<>();
        
        if (s ==  null || s.length() == 0) {
            return result;
        }
        if (wordDict.contains(s)) {
            result.add(s);
        }
        
        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(0, i);
            if (!wordDict.contains(s1)) {
                continue;
            }
            
            String s2 = s.substring(i);
            List<String> temp = dfs(s2, wordDict, map);
            
            for (String word : temp) {
                result.add(s1 + " " + word);
            }
        }
        
        map.put(s, result);
        return result;
    }
}
