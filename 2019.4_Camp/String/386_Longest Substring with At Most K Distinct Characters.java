public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        //sliding window
        if (s.length() == 0) {
            return 0;
        }
        
        //记录当滑动窗口内满足条件的最大长度
        int maxLen = 0;
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
            //if curCount > k need to move left
            if (curCount > k) {
                count[s.charAt(left)]--;
                //有唯一出现被删除的字母 curcount--
                if (count[s.charAt(left)] == 0) {
                    curCount--;
                }
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        
        return maxLen;
    }
}
