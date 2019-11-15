public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
                                //i- 1 没选， 若i同i- 1相同，则同样不选
                                
                                //i > Index means 
                                //上一轮是index - 1, 当前是i， i - （index - 1）>= 1,
                                //两者之间至少有一个数， 所以i- 1 没放入，所以i与i- 1相等的时候也不能放入
                                if (i > startIndex && nums[i] == nums[i - 1]) {
                                    continue;
                                }
                                subset.add(nums[i]);
                                helper(nums, i + 1, results, subset);
                                subset.remove(subset.size() - 1);
                            }
    }
}
