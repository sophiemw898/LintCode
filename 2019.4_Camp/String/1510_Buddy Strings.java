public class Solution {
    /**
     * @param A: string A
     * @param B: string B
     * @return: bool
     */
    public boolean buddyStrings(String A, String B) {
        // Write your code here
        //case1. 长度不等 flase
        if (A.length() != B.length()) {
            return false;
        }   
        
        //case2. 字符串完全相同，看是否有相同字母
        if (A.equals(B)) {
            Set<Character> set = new HashSet<>();
            for (char c : A.toCharArray()) {
                set.add(c);
            }
            return set.size() < A.length();
        }
        
        //case3. 不同字符串 看是否仅有两个字母不同
        //       且满足A[i] == B[j] && A[j] == B[i]
        List<Integer> chars = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                chars.add(i);
            }
        }
        
        return chars.size() == 2 && 
        A.charAt(chars.get(0)) == B.charAt(chars.get(1)) && 
        A.charAt(chars.get(1)) == B.charAt(chars.get(0));
    }
}
