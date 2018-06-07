public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            int[] res = {};
            return res;
        }
        
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i] + target;
            if (map.containsKey(sum)) {
                res[0] = map.get(sum) + 1;
                res[1] = i + 1;
                return res;
            }
            
            int diff = nums[i] - target;
            if (map.containsKey(diff)) {
                res[0] = map.get(diff) + 1;
                res[1] = i + 1;
                return res;
            }
            
            map.put(nums[i], i);
        }
        
        return res;
    }
}
O(n) O(n)
