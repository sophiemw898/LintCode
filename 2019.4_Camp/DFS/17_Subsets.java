public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        if (nums == null) {
            res.add(new ArrayList<>());
            return res;
        }
        Arrays.sort(nums);
        helper (nums, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void helper(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> res) {
        res.add(new ArrayList<>(subset));
        
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            helper(nums, i + 1, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}
