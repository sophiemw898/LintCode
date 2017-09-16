public class Solution {
    /*
     * @param s: Roman representation
     * @return: an integer
    */
    public int romanToInt(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int res = map.get(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++) {
            if (map.get(s.charAt(i)) <= map.get(s.charAt(i - 1))) {
                res += map.get(s.charAt(i));
            } else {
                res = res + map.get(s.charAt(i)) - map.get(s.charAt(i - 1)) * 2;
            }
        }
        return res;
    }
}
/*
public class Solution {
 	public int romanToInt(String s) {
	    if (s == null || s.length()==0) {
                return 0;
	    }
	    Map<Character, Integer> m = new HashMap<Character, Integer>();
	    m.put('I', 1);
	    m.put('V', 5);
	    m.put('X', 10);
	    m.put('L', 50);
	    m.put('C', 100);
	    m.put('D', 500);
	    m.put('M', 1000);

	    int length = s.length();
	    int result = m.get(s.charAt(length - 1));
	    for (int i = length - 2; i >= 0; i--) {
	        if (m.get(s.charAt(i + 1)) <= m.get(s.charAt(i))) {
	            result += m.get(s.charAt(i));
	        } else {
	            result -= m.get(s.charAt(i));
	        }
	    }
	    return result;
	}
}*/
