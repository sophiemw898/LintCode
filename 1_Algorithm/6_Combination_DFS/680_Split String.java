public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        List<List<String>> results = new ArrayList<>();
        List<String> subset = new ArrayList<>();
        
        if (s == null) {
            return results;
        }
        if (s.length() == 0) {
            results.add(subset);
            return results;
        }
        //以第0位开始的所有subset
        helper(s, 0, results, subset);
        return results;
    }
    
    //1. definition
    private void helper(String s, int index, List<List<String>> results, List<String> subset) {
        if (index == s.length()) {
            results.add(new ArrayList<String>(subset));
            return;
        }
        
        for (int i = 1; i < 3; i++) {
            if (index + i <= s.length()) {
                subset.add(s.substring(index, index + i));
                //System.out.println(subset);
                helper(s, index + i, results, subset);
                subset.remove(subset.size() - 1);
            }
        }
    }
}

Input
"123"
Your stdout
[1]
[1, 2]
[1, 2, 3]
[1, 23]
[12]
[12, 3]
Output
[["1","23"],["12","3"],["1","2","3"]]
Expected
[["1","23"],["12","3"],["1","2","3"]]
