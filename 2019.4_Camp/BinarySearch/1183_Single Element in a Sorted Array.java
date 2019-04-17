public class Solution {
    /**
     * @param nums: a list of integers
     * @return: return a integer
     */
    public int singleNonDuplicate(int[] nums) {
        // write your code here
        //二分找中点mid，取最近的偶数，mid和mid+1相等，则在后半部分start= mid、
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            mid = (mid%2 == 1) ? mid - 1: mid;
            if (nums[mid] == nums[mid + 1]) {
                start = mid + 2;
            } else {
                end = mid;
            }
        }
        System.out.println(start);
        System.out.println(end);
        
        return nums[start];
    }
}
