public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null) {
            return 0;
        }
        if (start.equals(end)) {
            return 1;
        }
        dict.add(start);
        dict.add(end);
        
        //initialize the hash and queue
        Set<String> hash = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        hash.add(start);
        queue.offer(start);
        
        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord : getNextWords(dict, word)) {
                    if (hash.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return length;
                    }
                    queue.offer(nextWord);
                    hash.add(nextWord);
                }
            }
        }
        
        return 0;
    }
    
    // get connections with given word.
    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
    // it will return ['hit', 'hog']
    private ArrayList<String> getNextWords(Set<String> dict, String word) {
        ArrayList<String> nextWords = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c) {
                    continue;
                }
                
                String nextWord = replace(word, c, i);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        
        return nextWords;
    }
    
    // replace character of a string at given index to a given character
    // return a new string
    private String replace(String word, char c, int i) {
        char[] chars = word.toCharArray();
        chars[i] = c;
        String newWord = new String(chars);
        return newWord;
    }
}
