//hashmap两中写法
public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        int[] record = new int[256];
        
        for (int i = 0; i < str.length(); i++) {
            record[str.charAt(i)]++;
        }
        
        for (int i = 0; i < str.length(); i++) {
            if (record[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        
        return Character.MIN_VALUE;
    }
}

public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
            } else {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
        }
        
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return str.charAt(i);
            }
        }
        
        return Character.MIN_VALUE;
    }
}
