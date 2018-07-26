public class Solution {
    public List<Integer> subarraySum(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (sum[i] == 0) {
                res.add(0);
                res.add(i);
                break;
            }
            if (map.containsKey(sum[i])) {
                res.add(map.get(sum[i]) + 1);
                res.add(i);
                break;
            } else {
                map.put(sum[i], i);
            }
        }
        
        return res;
    }
}
