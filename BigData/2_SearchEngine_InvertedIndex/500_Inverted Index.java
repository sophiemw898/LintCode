/**
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */
public class Solution {
    /**
     * @param docs a list of documents
     * @return an inverted index
     */
    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        // Write your code here
        Map<String, List<Integer>> results = new HashMap<>();
        for (Document doc : docs) {
            int id = doc.id;
            String content = doc.content;
            StringBuilder temp = new StringBuilder();
            
            for (int i = 0; i < content.length(); i++) {
                if (content.charAt(i) == ' ') {
                    invert(results, temp.toString(),id);
                    temp = new StringBuilder();
                } else {
                    temp.append(content.charAt(i));
                }
            }
            invert(results, temp.toString(),id);
        }
        return results;
    }
    
    private void invert (Map<String, List<Integer>> results, String temp, int id) {
        if (temp == null || temp.length() == 0) {
            return;
        }
        if (!results.containsKey(temp)) {
            results.put(temp, new ArrayList<Integer>());
        }
        int n = results.get(temp).size();
        if (n == 0 || results.get(temp).get(n - 1) != id) {
            results.get(temp).add(id);
        }
    }
}
