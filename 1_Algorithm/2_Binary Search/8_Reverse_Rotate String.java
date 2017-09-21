time O(n) space O(1)
public class Solution {
    /*
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str == null || str.length == 0) {
            return;
        }
        offset %= str.length; //in case offset > str.length
        reverse(str, 0, str.length - 1 - offset);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length -1);
    }
    
    public void reverse(char[] str, int start, int end) {
        if (str == null || str.length == 0) {
            return;
        }
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
}
