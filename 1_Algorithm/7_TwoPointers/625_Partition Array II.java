public class Solution {
    /*
     * @param nums: an integer array
     * @param low: An integer
     * @param high: An integer
     * @return: 
     */
    public void partition2(int[] nums, int low, int high) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return;
        }
        
        int left = 0, right = nums.length - 1;
        int i = 0;
        
        while (i <= right) {
            if (nums[i] < low) {
                swap (nums, left, i);
                i++;
                left++;
            } else if (nums[i] >= low && nums[i] <= high) {
                i++;
            } else if (nums[i] > high) {
                swap (nums, right, i);
                right--;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
