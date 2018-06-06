public class Solution {
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return -1;
        }
        
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int diff = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        
        while (i < j) {
            diff = target - nums[i] - nums[j];
            res = Math.min(res, Math.abs(diff));
            if (diff < 0) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }
}

O(nlogn)
