public class Solution {
    /**
     * @param str: A string
     * @return: An integer
     */
    public int stringToInteger(String str) {
        // write your code here
        //return Integer.valueOf(str);
        
        int integer = 0;
        int ifMinus = 0;
        
        //check if it is negtive
        if (str.charAt(0) == '-') {
            ifMinus = 1;
        }        
        
        //traver all String
        for (int i = ifMinus; i < str.length(); i++) {
            integer = 10 * integer + (str.charAt(i) - '0');
        }
        
        //return negtive integer
        if (ifMinus == 1) {
            integer = -integer;
        }
        
        return integer;
    }
}
