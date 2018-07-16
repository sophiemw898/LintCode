public class Solution {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        List<String> results = new ArrayList<>();
        String path = "";
        if (str == null) {
            return results;
        }
        if (str.length() == 0) {
            results.add(path);
            return results;
        }
        
        char[] chars = str.toCharArray(); 
        boolean[] isVisited = new boolean[str.length()];
        Arrays.sort(chars);
        
        helper(chars, isVisited, results, path);
        return results;
    }
    
    private void helper(char[] chars, boolean[] isVisited, List<String> results, String path) {
        if (path.length() == chars.length) {
            results.add(path);
            return;
        }
        
        for (int i = 0; i < chars.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            if (i != 0 && !isVisited[i - 1] && chars[i] == chars[i - 1]) {
                continue;
            }
            path = path + chars[i];
            isVisited[i] = true;
            helper(chars, isVisited, results, path);
            isVisited[i] = false;
            path =  path.substring(0, path.length() - 1);
        }
    }
}
