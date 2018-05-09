public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                int[] res =  new int[2];
                res[0] = start + 1;
                res[1] = end + 1;
                return res;
            }
            if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return null;
    }
}
