public class Solution {
    /*
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
    
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        
        helper(nums, path, res, 0);
        return res;
        }
        
    public void helper(int[] nums, List<Integer> path, List<List<Integer>> res, int pos) {
        res.add(new ArrayList<>(path));
        
        for(int i = pos; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, path, res, i + 1);
            path.remove(path.size() - 1);
        }
        return;
    } 
}
