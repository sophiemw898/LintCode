//先找出数组中每个数的分子数
//选取最大分的数
//将所有的分子打印出来
public class Solution {
    /*
     * @param nums: a set of distinct positive integers
     * @return: the largest subset 
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        int[] dp = new int[nums.length];//dp[] present 之前出现分子的个数
        int[] pre = new int[nums.length];//pre[] present 最后一个分子所在的位置
        
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;//默认最少有一个分子即自己
            pre[i] = i;//默认最后一个分子是自己
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] ==0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
        }
        
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < dp[i]) {
                max = dp[i];
                maxIndex = i;
            }
        }
        
        result.add(nums[maxIndex]);
        
        while (pre[maxIndex] != maxIndex) {
            maxIndex = pre[maxIndex];
            result.add(nums[maxIndex]);
        }
        
        Collections.reverse(result);
        return result;
    }
}
