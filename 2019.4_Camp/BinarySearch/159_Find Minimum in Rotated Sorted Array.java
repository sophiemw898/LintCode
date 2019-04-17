public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        //找标准的时候需要考虑array没有rotate的情况 nums[nums.length -1]
        //if (mid > the last num)  start = mid --in the right part
        //if (mid <= the last num) in the left part
        int start = 0, end = nums.length - 1;
        int standard = nums[end];
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= standard) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        //return (nums[start] < nums[end]) ? nums[start] : nums[end];
        return Math.min(nums[start], nums[end]);
    }
}
