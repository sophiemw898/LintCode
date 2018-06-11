public class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        //left points to the first num != 0
        //right points to the first num != 2 000/left.....right/2222
        int left = 0, right = nums.length - 1;
        int i = 0;
        
        while (i <=right) {
            if (nums[i] == 0) {
                swap (nums, i, left);
                i++;
                left++;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap (nums, i, right);
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
