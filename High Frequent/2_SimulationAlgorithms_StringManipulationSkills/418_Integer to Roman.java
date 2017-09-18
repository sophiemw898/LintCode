public class Solution {
    /*
     * @param n: The integer
     * @return: Roman representation
     */
    public String intToRoman(int n) {
        // write your code here
        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        
        //return M[n / 1000] + C[(n / 100) % 10] + X[(n / 10) % 10] + I[n % 10];
        int[] digit = new int[4];
        int i = 0;
        while (n != 0) {
            digit[i] = n % 10;
            i++;
            n /= 10;
        }
        return M[digit[3]] + C[digit[2]] + X[digit[1]] + I[digit[0]];
    }
}
