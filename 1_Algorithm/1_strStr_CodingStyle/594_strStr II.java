//hashfunction 
public class Solution {
    /*
     * @param source: A source string
     * @param target: A target string
     * @return: An integer as index
     */ 
    public int BASE = 1000000;
    public int strStr2(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        if (target.length() == 0) {
            return 0;
        }
        
        int targetCode = 0;
        for (int i = 0; i < target.length(); i++) {
            targetCode = (targetCode * 31 + target.charAt(i) - 'a') % BASE;
        }
        
        // 31 ^ m
        int m = target.length();
        int power = 1;
        for (int i = 0; i < m; i++) {
            power = (power * 31) % BASE;
        }
        
        int hashCode = 0;
        for (int i = 0; i < source.length(); i++) {
            //abc + d
            hashCode = (hashCode * 31 + source.charAt(i) - 'a') % BASE;
            if (i < m - 1) {
                continue;
            }
            //...i
            //abcd - d
            if (i >= m) {
                hashCode = hashCode - ((source.charAt(i - m) - 'a') * power) % BASE;
                if (hashCode < 0) {
                    hashCode += BASE;
                }
            }
            
            //double check the string
            if (hashCode == targetCode) {
                if (source.substring(i - m + 1, i + 1).equals(target)) {
                    return i - m + 1;
                }
            }
        }
        return -1;
    }
}
