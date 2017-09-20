public class Solution {
    /*
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        //to find the first number <= last number
        //target = nums[nums.length - 1];
        if (nums == null || nums.length == 0) {
            return -1;
        }//based on the discription
        int start = 0;
        int end = nums.length - 1;
        int target = nums[nums.length - 1];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return nums[start] < nums[end] ? nums[start] : nums[end];
    }
}
O(log N)
