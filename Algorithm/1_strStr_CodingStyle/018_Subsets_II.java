public class Solution {
    /*
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        
        helper(nums, res, path, 0);
        return res;
    }
    public void helper(int[] nums, List<List<Integer>> res, List<Integer> path, int pos) {
        res.add(new ArrayList<>(path));
        
        for (int i = pos; i < nums.length; i++) {
            
            if(i != pos && nums[i] == nums[i-1]) {
                continue;
            }
            path.add(nums[i]);
            helper(nums, res, path, i + 1);
            path.remove(path.size() - 1);
        }
        return;
    }
}
