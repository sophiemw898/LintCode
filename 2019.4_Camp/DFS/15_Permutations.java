public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        if (nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        
        List<Integer> path = new ArrayList<>();
        helper(nums, new boolean[nums.length], path, res);
        
        return res;
    }
    
    private void helper(int[] nums, boolean[] isVisited, List<Integer> path,  List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<Integer>(path));
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            
            path.add(nums[i]);
            isVisited[i] = true;
            helper(nums, isVisited, path, res);
            isVisited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
