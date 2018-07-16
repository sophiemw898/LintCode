public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
                List<List<Integer>> results = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        if (nums.length == 0) {
            results.add(permutation);
            return results;
        }
        
        Arrays.sort(nums);//必须先排序才能再去重
        boolean[] isVisited = new boolean[nums.length];
        helper(nums, isVisited, results, permutation);
        
        return results;
    }
    
    //1. 递归的定义 找到所有以permutation开头的排列
    private void helper(int[] nums, boolean[] isVisited, List<List<Integer>> results, List<Integer> permutation) {
        //3. 递归的出口
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<Integer>(permutation));
            return;
        }
        
        //2. 递归的拆解
        //有重复的情况下明显去重用数组isVisited 更方便
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            if (i != 0 && !isVisited[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }
            permutation.add(nums[i]);
            isVisited[i] = true;;
            helper(nums, isVisited, results, permutation);
            isVisited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
}
