public class Solution {
    /*
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        
        if (nums == null) {
            return results;
        }
        
        if (nums.length == 0) {
            results.add(subset);
            return results;
        }
        
        Arrays.sort(nums);
        //找到所有【】开头的集合，并加到 results
        helper(nums, 0, results, subset);
        return results;
    }
    
    //递归三要素 
    //1.递归的定义 
    //找到所有 subset开头的集合，并加到 results
    private void helper(int[] nums, int startIndex,
                        List<List<Integer>> results, List<Integer> subset) {
                            
                            // 2. 递归的拆解
                            // deep copy
                            results.add(new ArrayList<Integer>(subset));
                            
                            for (int i = startIndex; i < nums.length; i++) {
                                // [1] -> [1,2]
                                subset.add(nums[i]);
                                // 寻找所有以 [1,2] 开头的集合，并扔到 results
                                helper(nums, i + 1, results, subset);
                                // [1,2] -> [1]  回溯
                                subset.remove(subset.size() - 1);
                            }
                            
                            // 3. 递归的出口
                            // return;
                            
                        }
}
