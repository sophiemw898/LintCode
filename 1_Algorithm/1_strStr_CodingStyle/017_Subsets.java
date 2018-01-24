Space O（N）

public class Solution {
    /*
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> sebset = new ArrayList<>();
        
        if (nums == null) {
            return results;
        }
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        //Deduplication
        Arrays.sort(nums);
        //找到所有【】开头的集合，并加到 results
        helper(sebset, nums, 0, results);
        return results;
    } 
    //递归三要素 
    //1.递归的定义 
    //找到所有 subset开头的集合，并加到 results
    private void helper(List<Integer> subset, int[] nums, int startIndex, List<List<Integer>> results) {
        //2.递归的拆解 deep copy 
        results.add(new ArrayList<Integer>(subset));
        
        for(int i = startIndex; i < nums.length; i++) {
            //尝试寻找 subset+ [nums[i]]开头的所有的子集 
            //[] + [1]
            //[] + [2]
            subset.add(nums[i]);
            helper(subset, nums, i + 1, results);
            //backtracking
            subset.remove(subset.size() - 1);
        }
        //3.递归的出口 
    }
}
