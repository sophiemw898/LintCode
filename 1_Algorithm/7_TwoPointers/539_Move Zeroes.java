public class Solution {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    
    public void moveZeroes(int[] nums) {
        // write your code here
        int i = 0, j = 0;
        //j point to the first 0
        while (i < nums.length) {
            if (nums[i] != 0) {
                reverse(nums, i, j);
                j++;
            }
            i++;
        }
    }
    
    private void reverse(int[]nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
