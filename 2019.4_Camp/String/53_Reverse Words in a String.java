public class Solution {
    /*
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        // write your code here
        if (s.length() <= 1) {
            return s;
        }
        
        String[] words = s.split(" ");
        System.out.println(words);
        StringBuilder sb = new StringBuilder();
        
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].equals("")) {
                sb.append(words[i]);
                sb.append(" ");
            }
        }
        
        //corner case "    "
        if (sb.toString().length() == 0) {
            return "";
        }
        
        return sb.toString().substring(0, sb.toString().length() - 1);
        
        
        // for (int i = words.length - 1; i >= 0; i--) {
        //     if (!words[i].equals("")) {
        //         if (sb.toString().length() > 0) {
        //             sb.append(" ");
        //         }
        //         sb.append(words[i]);
        //     }
        // }
        
        // return sb.toString();
    }
}
