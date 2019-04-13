public class Solution {
    /**
     * @param nums: List[int]
     * @return: return List[str]
     */
    public String[] findRelativeRanks(int[] nums) {
        // write your code here
        String[] result = new String[nums.length];
        
        //use map to record the nums and their position
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        //sort the nums aec 12345
        Arrays.sort(nums);
        //sort the nums dec 54321
        for (int i = 0; i < nums.length/2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        //top3 with medal, after top3 the position is i+1
        for (int i = 0; i < nums.length; i++) {
            String rank = String.valueOf(i + 1);
            if (i == 0) {
                rank = "Gold Medal";
            }
            if (i == 1) {
                rank = "Silver Medal";
            }
            if (i == 2) {
                rank = "Bronze Medal";
            }
            result[map.get(nums[i])] = rank;
        }
        
        return result;
    }
}
