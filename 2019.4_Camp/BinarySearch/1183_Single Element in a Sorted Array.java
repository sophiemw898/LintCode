public class Solution {
    /**
     * @param nums: a list of integers
     * @return: return a integer
     */
    public int singleNonDuplicate(int[] nums) {
        // write your code here
        //二分找中点mid，取最近的偶数，mid和mid+1相等，则在后半部分start= mid、
        int start = 0, end = nums.length - 1;
        // while (start + 1 < end) {
        //     int mid = start + (end - start) / 2;
        //     //mid向下取偶数 所以后面start = mid + 2 不然会死循环
        //     mid = (mid%2 == 1) ? mid - 1: mid;
        //     if (nums[mid] == nums[mid + 1]) {
        //         start = mid + 2;
        //     } else {
        //         end = mid;
        //     }
        // }
        
        //method2 mid分开写 
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid % 2 == 1) {
                //mid is odd 
                if (nums[mid] == nums[mid - 1]) {
                    start = mid;
                } else { 
                    end = mid;
                }
            } else {
                if (nums[mid] == nums[mid + 1]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        
        if (start % 2 == 0) {
            return nums[start];
        } else {
            return nums[end];
        }
    }
}
