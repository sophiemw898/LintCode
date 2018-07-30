class NumArray {
    
    private int[] dp = null;
    
    public NumArray(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp [i - 1] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return i == 0 ? dp[j] : dp[j] - dp[i - 1];
    }
}

class NumArray {
    
    private int[] dp = null;
    
    public NumArray(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1];
    
        for (int i = 0; i < n; i++) {
            dp[i + 1] = dp [i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
 
 
