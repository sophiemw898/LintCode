public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        helper(n, k, 1, results, path);
        return results;
    }
    
    private void helper(int n, int k, int index, 
                        List<List<Integer>> results, List<Integer> path) {
        if (path.size() == k) {
            results.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int i = index; i <= n; i++) {
            path.add(i);
            helper(n, k, i + 1, results, path);
            path.remove(path.size() - 1);
        }
    }
}
