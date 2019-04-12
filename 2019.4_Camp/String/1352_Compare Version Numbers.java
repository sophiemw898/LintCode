public class Solution {
    /**
     * @param version1: the first given number
     * @param version2: the second given number
     * @return: the result of comparing
     */
    public int compareVersion(String version1, String version2) {
        // Write your code here
        String[] vers1 = version1.split("\\.");
        String[] vers2 = version2.split("\\.");
        
        // String[] vers1 = version1.split(".");
        // String[] vers2 = version2.split(".");
        
        // System.out.println(vers1);
        // System.out.println(vers2);
        
        for (int i = 0; i < Math.max(vers1.length, vers2.length); i++) {
            int v1 = i < vers1.length ? Integer.parseInt(vers1[i]) : 0;
            int v2 = i < vers2.length ? Integer.parseInt(vers2[i]) : 0;
            if (v1 > v2) {
                return 1;
            }
            if (v1 < v2) {
                return -1;
            }
        }
        
        return 0;
    }
}
