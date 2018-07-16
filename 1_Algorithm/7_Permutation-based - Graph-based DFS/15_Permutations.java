public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        if (nums.length == 0) {
            results.add(permutation);
            return results;
        }
        
        Set<Integer> set = new HashSet<>();
        helper(nums, set, results, permutation);
        
        return results;
    }
    
    //1. 递归的定义 找到所有以permutation开头的排列
    private void helper(int[] nums, Set<Integer> set, List<List<Integer>> results, List<Integer> permutation) {
        //3. 递归的出口
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<Integer>(permutation));
            return;
        }
        
        //2. 递归的拆解
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            permutation.add(nums[i]);
            set.add(nums[i]);
            helper(nums, set, results, permutation);
            set.remove(nums[i]);
            permutation.remove(permutation.size() - 1);
        }
    }
}
