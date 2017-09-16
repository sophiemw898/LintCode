public class Solution {
    /**
     * @param dict an array of n distinct non-empty strings
     * @return an array of minimal possible abbreviations for every word
     */
    public String[] wordsAbbreviation(String[] dict) {
        // Write your code here
        String[] res = new String[dict.length];
        if (dict == null || dict.length == 0) {
            return res;
        }
        int[] prepos = new int[dict.length];
        Map<String, Integer> map = new HashMap<>();
        //初始化第一轮result&map
        for (int i = 0; i < dict.length; i++) {
            prepos[i] = 1;
            res[i] = abbr(dict[i], 1);
            if (!map.containsKey(res[i])) {
                map.put(res[i], 1);
            } else {
                map.put(res[i], map.get(res[i]) + 1);
            }
        }
       
        while (true) {
            boolean check = true;
            for (int i = 0; i < dict.length; i++) {
                if (map.get(res[i]) > 1) {
                    prepos[i]++;
                    res[i] = abbr(dict[i], prepos[i]);
                    if (!map.containsKey(res[i])) {
                        map.put(res[i], 1);
                    } else {
                        map.put(res[i], map.get(res[i]) + 1);
                        check = false;
                    }
                }
            }
            if(check) {
                break;
            }
        }
        return res;
    }

    public String abbr(String s, int pos) {
        StringBuilder builder = new StringBuilder();
        if (pos >= s.length() - 2) {
            builder.append(s);
            return builder.toString();
        }
        for (int i = 0; i < pos; i++) {
            builder.append(s.charAt(i));
        }
        builder.append(s.length() - 1 - pos);
        builder.append(s.charAt(s.length() - 1));
        return builder.toString();
    }
}  

/*String abbr(String s, int p) {
        if (p >= s.length() - 2) {
            return s;
        }
        String ans;
        ans = s.substring(0, p) + (s.length() - 1 - p) + s.charAt(s.length() - 1);
        return ans;*/
