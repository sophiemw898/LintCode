public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        
        Arrays.sort(candidates);
        //把所有以【 】开头和为target的组合放到results里
        helper(candidates, target, 0, results, path);
        return results;
    }
    
    //1. 递归的定义
    //找到所有以path开头的那些和为target的组合并丢到results里
    //其中剩余需要加入path里的数， 和为target- candidates【i】
    //并且下一个可以加入path的数至少从candidates的index开始
    private void helper(int[] candidates, int target, int index, 
                        List<List<Integer>> results, List<Integer> path) {
        //3. 递归的出口
        if (target == 0) {
            results.add(new ArrayList<Integer>(path));
            return;
        }
        
        //2. 递归的拆解
        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i]) {
                break;
            }
            //【2，2，3，3，7】 7 
            if (i != 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i, results, path);
            path.remove(path.size() - 1);
        }
    }
}
