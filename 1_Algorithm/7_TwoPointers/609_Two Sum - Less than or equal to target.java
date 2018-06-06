public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            if (nums[right] + nums[left] > target) {
                right--;
            } else {
                count += right - left;
                left++;
            }
        }
        return count;
    }
}
