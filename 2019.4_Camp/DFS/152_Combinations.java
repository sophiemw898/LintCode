public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k <= 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        
        List<Integer> temp = new ArrayList<>();
        helper(1, n, k, temp, res);
        return res;
    }
    
    private void helper(int pos, int n, int k, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == k) {
            res.add(new ArrayList<Integer> (temp));
        }
        
        for (int i = pos; i <= n; i++) {
            temp.add(i);
            helper(i + 1, n, k, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
