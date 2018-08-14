public class Solution {
    /*
     * @param s: a string
     * @param dict: a set of n substrings
     * @return: the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        
        queue.offer(s);
        set.add(s);
        int minLength = s.length();
        
        while (!queue.isEmpty()) {
            s = queue.poll();
            for(String sub : dict) {
                int index = s.indexOf(sub);
                while (index != -1) {
                    String new_s = s.substring(0, index) + s.substring(index + sub.length(), s.length());
                    if (!set.contains(new_s)) {
                        if (new_s.length() < minLength) {
                        minLength = new_s.length();
                        }
                        queue.offer(new_s);
                        set.add(new_s);
                    }
                    index = s.indexOf(sub, index + sub.length());
                }
            }
        }
        
        return minLength;
    }
}
