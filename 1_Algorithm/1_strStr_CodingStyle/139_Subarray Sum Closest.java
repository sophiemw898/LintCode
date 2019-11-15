class Pair {
    int sum;
    int index;
    public Pair (int sum, int index) {
        this.sum = sum;
        this.index = index;
    }
}

public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res[0] = 0;
            res[1] = 0;
            return res;
        }
        
        //creat the array of preSum and save the values and index
        Pair[] preSum = new Pair[nums.length + 1];
        preSum[0] = new Pair(0, 0);
        for (int i = 1; i < preSum.length; i++) {
            // System.out.println(i);
            // System.out.println(preSum[i - 1].sum);
            // System.out.println(nums[i - 1]);
            preSum[i] = new Pair(preSum[i - 1].sum + nums[i - 1], i);
        }
        
        //sort the preSum from samll to big
        Arrays.sort(preSum, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }
        });
        
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < preSum.length; i++) {
            if (preSum[i].sum - preSum[i - 1].sum < min) {
                min = preSum[i].sum - preSum[i - 1].sum;
                // res[1] = preSum[i].index;
                // res[0] = preSum[i - 1].index + 1;
                //不确定哪个index大
                if (preSum[i - 1].index < preSum[i].index) {
                    res[1] = preSum[i].index - 1;
                    res[0] = preSum[i - 1].index;
                } else {
                    res[1] = preSum[i - 1].index - 1;
                    res[0] = preSum[i].index;
                }
            }
        }
        
        return res;
    }
}
