public class Solution {
    /*
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        // write your code here
        for (int i = 0; i < s.length() && i < t.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));// s has the same length as t, so the only possibility is replacing one char in s and t
                } else if (s.length() < t.length()) {
                    return s.substring(i).equals(t.substring(i + 1));// t is longer than s, so the only possibility is deleting one char from t
                } else {
                    return s.substring(i + 1).equals(t.substring(i));// s is longer than t, so the only possibility is deleting one char from s
                }
            }
        }
        //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t 
        return Math.abs(s.length() - t.length()) == 1;
    }
}

/*
 * There're 3 possibilities to satisfy one edit distance apart: 
 * 
 * 1) Replace 1 char:
 	  s: a B c
 	  t: a D c
 * 2) Delete 1 char from s: 
	  s: a D  b c
	  t: a    b c
 * 3) Delete 1 char from t
	  s: a   b c
	  t: a D b c
 */O(n)
public class Solution {
    /*
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        // write your code here
	    if(s.length() > t.length()) {
		    return isOneEditDistance(t, s);
	    }
	    int diff = t.length() - s.length();
	
	    if (diff > 1) {
		    return false;
	    }
	    if (diff == 1) {
	    	for (int i = 0; i < s.length(); i++) {
		    	if (s.charAt(i) != t.charAt(i)) {
			    	return s.substring(i).equals(t.substring(i+1));
			    }
		    }
	    }
	    if (diff == 0) {
	      int count = 0;
	    	for (int i = 0; i < s.length(); i++) {
			    if (s.charAt(i) != t.charAt(i)) {
			    	count++;
			    }
		    }
		    return (count == 1);
	    }
    	return true;
    }
}
