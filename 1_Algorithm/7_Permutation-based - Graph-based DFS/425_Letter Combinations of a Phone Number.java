//高频题班还有个解法
public class Solution {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return results;
        }
        
        Map<Character, char[]> map = new HashMap<>();
        map.put('0',new char[] {});
        map.put('1',new char[] {});
        map.put('2',new char[] {'a', 'b', 'c'});
        map.put('3',new char[] {'d', 'e', 'f'});
        map.put('4',new char[] {'g', 'h', 'i'});
        map.put('5',new char[] {'j', 'k', 'l'});
        map.put('6',new char[] {'m', 'n', 'o'});
        map.put('7',new char[] {'p', 'q', 'r', 's'});
        map.put('8',new char[] {'t', 'u', 'v'});
        map.put('9',new char[] {'w', 'x', 'y', 'z'});
        
        StringBuilder sb = new StringBuilder();
        helper(digits, map, sb, results);
        return results;
    }
    
    private void helper(String digits, Map<Character, char[]> map, StringBuilder sb, 
                        List<String> results) {
                            if (sb.length() == digits.length()) {
                                results.add(sb.toString());
                                return;
                            }
                            
                            for (char c : map.get(digits.charAt(sb.length()))) {
                                sb.append(c);
                                helper(digits, map, sb, results);
                                sb.deleteCharAt(sb.length() - 1);
                            }
                        }
}
