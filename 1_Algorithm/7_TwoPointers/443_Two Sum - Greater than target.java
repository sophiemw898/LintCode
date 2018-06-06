public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right) {
            int sum = nums[right] + nums[left];
            if (sum <= target) {
                left++;
            } else {
                count += right - left;
                right--;
            }
        }
        return count;
    }
}
O(nlogn) O(1)
