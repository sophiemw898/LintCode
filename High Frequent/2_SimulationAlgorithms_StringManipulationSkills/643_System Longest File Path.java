public class Solution {
    /*
     * @param input: an abstract file system
     * @return: return the length of the longest absolute path to file
     */
    public int lengthLongestPath(String input) {
        // write your code here
        if (input.length() == 0) {
            return 0;
        }
        int ans = 0;
        int[] size = new int[input.length() + 1];
        
        for (String str : input.split("\n")) {
            //use lastIndexOf to return the num of \t
            //no \t, return -1, thus +2. so level 1,2,3
            int level = str.lastIndexOf("\t") + 2; 
            
            int len = str.length() - (level - 1);
            if (str.contains(".")) {
                ans = Math.max(ans, size[level - 1] + len);
            } else {
                size[level] = size[level - 1] + len + 1;
            }
        }
        return ans;
    }
}
