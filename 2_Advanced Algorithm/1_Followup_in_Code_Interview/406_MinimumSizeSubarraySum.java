public class Solution {
    /*
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        int i = 0;
        int j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for (i = 0; i < nums.length; i++) {
            while (j < nums.length) {
                if (sum < s) {
                    sum += nums[j];
                    j++;
                } else {
                    ans = Math.min(ans, j - i);
                    break;
                }
            }
            ans -= nums[i];
        }
        return ans;
    }
}
