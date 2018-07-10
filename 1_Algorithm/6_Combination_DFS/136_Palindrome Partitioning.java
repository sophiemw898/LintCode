public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }
        
        helper(s, 0, results, partition);
        return results;
    }
    
    private void helper(String s, int startIndex, List<List<String>> results, List<String> partition) {
        if (startIndex == s.length()) {
            results.add(new ArrayList<String>(partition));
            return;
        }
        //i 表示切割的位置，这里是随便切，若只能切一个或者两个单词，
        //则加上条件i < starIndex + 2
        for (int i = startIndex; i < s.length(); i++) {
            //单词切割成0 - i， 下一层循环的初始位置是i + 1
            String subString = s.substring(startIndex, i + 1);
            if (!isPalindrome(subString)) {
                continue;
            }
            partition.add(subString);
            helper(s, i + 1, results, partition);
            partition.remove(partition.size() - 1);
        }
    }
    
    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
