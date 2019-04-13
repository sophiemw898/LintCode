public class Solution {
    /**
     * @param strs: List[str]
     * @return: return an integer
     */
    public int findLUSlength(String[] strs) {
        // write your code here
        //先将字符串按长度从大到小进行排序，从长度最长的字符串开始遍历，每个字符串与其后的字符串进行比较，若其后的所有字符串均不是其子串，则该字符串即为最长非公共子串，输出结果，若存在，则结束本次比较，遍历至下一个字符串。
        
        //先将字符串按长度从大到小进行排
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        
        
        for (int i = 0; i < strs.length; i++) {
            //需要考虑前面长度>=的string
            boolean isUncommon = true;
            for (int j = 0; j < strs.length && strs[j].length() >= strs[i].length(); j++) {
                if (i == j) {
                    continue;
                }
                //如果strs[j]是subsequence 则不是uncommon
                if (isSubsequence(strs[j], strs[i])) {
                    isUncommon = false;
                    break;
                }
            }
            if (isUncommon) {
                return strs[i].length();
            }
        }
        
        return -1;
    }
    
    private boolean isSubsequence(String s1, String s2) {
        //here s1.length() >= s2.length()
        int index = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(index)) {
                index++;
            }
            if (index == s2.length()) {
                return true;
            }
        }
        
        return false;
    }
}
