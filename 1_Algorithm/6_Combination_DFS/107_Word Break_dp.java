//dp.............

public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        //1. dp defination
        // 长度为n的单词 有n + 1个切割点 比如: _l_i_n_t_
        boolean[] canSegment = new boolean[s.length() + 1];
        int maxLength = getMaxLength(dict);
        
        //2. dp initialization
        canSegment[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            canSegment[i] = false;
        }
        
        //3. dp loop
        for (int i = 1; i <= s.length(); i++) {
            //j lastWordLength
            //i - j 表示从 i 点开始往前j个点的位置
            for (int j = 1; j <= maxLength && j <= i; j++) {
                String str = s.substring(i - j, i);
                //如果此str在词典中 并且 str之前的 字符串可以拆分  
                if (dict.contains(str) && canSegment[i - j]) {
                    canSegment[i] = true;
                    break;
                }
            }
        }
        
        return canSegment[s.length()];
    }
    
    private int getMaxLength(Set<String> dict) {
        int max = 0;
        
        for (String word : dict) {
            if (word.length() > max) {
                max = word.length();
            }
        }
        
        return max;
    }
}

        
