public class Solution {
    /*
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (num == null || num.length == 0) {
            return results;
        }
        
        Arrays.sort(num);
        //把所有以【 】开头和为target的组合放到results里
        helper(num, target, 0, results, path);
        return results;
    }
    
    //1. 递归的定义
    //找到所有以path开头的那些和为target的组合并丢到results里
    //其中剩余需要加入path里的数， 和为target- num【i】
    //并且下一个可以加入path的数至少从num的index开始
    private void helper(int[] num, int target, int index, 
                        List<List<Integer>> results, List<Integer> path) {
        //3. 递归的出口
        if (target == 0) {
            results.add(new ArrayList<Integer>(path));
            return;
        }
        
        //2. 递归的拆解
        for (int i = index; i < num.length; i++) {
            if (target < num[i]) {
                break;
            }
            //i - 1 没被选中并且i= i-1的值 则i也不应该被选
            if (i > index && num[i] == num[i - 1]) {
                continue;
            }
            
            path.add(num[i]);
            helper(num, target - num[i], i + 1, results, path);
            path.remove(path.size() - 1);
        }
    }
}
