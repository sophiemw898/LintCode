public class Solution {
    /*
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        
        if (nums == null) {
            return results;
        }
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        
        Arrays.sort(nums);
        helper(subset, nums, 0, results);
        return results;
    }
    
    private void helper(List<Integer> subset, int[] nums, int startIndex, List<List<Integer>> results) {
        
        results.add(new ArrayList<Integer>(subset));
        
        for(int i = startIndex; i < nums.length; i++) {
            if(i != startIndex && nums[i] == nums[i - 1]) {
            //if(nums[i] == nums[i - 1] && i != startIndex) { NOT ACCEPTED
                continue;
            }
            subset.add(nums[i]);
            helper(subset, nums, i + 1, results);
            subset.remove(subset.size() - 1);
        }
    }
}
