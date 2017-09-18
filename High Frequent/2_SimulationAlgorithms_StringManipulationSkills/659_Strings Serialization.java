public class Solution {
    /**
     * @param strs a list of strings
     * @return encodes a list of strings to a single string.
     */
    
    public String encode(List<String> strs) {
        // Write your code here
       String ans = "";
       for (String s : strs) {
           for (char c : s.toCharArray()) {
               if (c == ':') {
                   ans += "::";
               } else {
                   ans += c;
               }
           }
           ans += ":;";
       }
       return ans;
    }
    
    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        String list = "";
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == ':') {
                if (str.charAt(i + 1) == ';') {
                    ans.add(list);
                    list = "";
                    i = i + 2;
                } else {
                    list += str.charAt(i + 1);
                    i = i + 2;
                }
            } else {
                list += str.charAt(i);
                i++;
            }
        }
        return ans;
    }
}
