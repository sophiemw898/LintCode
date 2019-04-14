public class Solution {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: the number of substrings there are that contain at least k distinct characters
     */
    public long kDistinctCharacters(String s, int k) {
        // Write your code here
        if (s == null) {
            return 0;
        }
        
        //记录当滑动窗口内满足条件的最大长度
        long res = 0;
        //记录滑动窗口的两端\
        int left = 0, right = 0;
        //记录当前滑动窗口内不同字符的个数
        int curCount = 0;
        //记录不同字符出现的个数
        int[] count = new int[256];
        
        while (left <= right && right < s.length()) {
            count[s.charAt(right)]++;
            //有第一次出现的字母 curcount++
            if (count[s.charAt(right)] == 1) {
                curCount++;
            }
            
            //if循环不成立 因为可能出现重复 例如aabc k=2
            while (curCount >= k) {
                res += s.length() - right;
                //System.out.println(res);
                //记录当前结果并右移left
                count[s.charAt(left)]--;
                //有唯一出现被删除的字母 curcount--
                if (count[s.charAt(left)] == 0) {
                    curCount--;
                }
                left++;
            }
            
            right++;
        }
            
        return res;
    }
}
