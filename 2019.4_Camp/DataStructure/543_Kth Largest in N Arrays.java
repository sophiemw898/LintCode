public class Solution {
    /**
     * @param arrays: a list of array
     * @param k: An integer
     * @return: an integer, K-th largest element in N arrays
     */
    public int KthInArrays(int[][] arrays, int k) {
        // 使用PriorityQueue遍历每个array，如果PriorityQueue中超过K个元素，poll出最小的
        //在遍历完所有数组的元素后，poll一次即可得到第K大元素
        if (arrays == null || arrays.length == 0) {
            return -1;
        }
        
        int len = arrays.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < len; i++) {
            //[[],[],[1],[1,2,3,4],[11,10,9,8,7]]
            if (arrays[i].length == 0) {
                continue;
            }
            
            for (int j = 0; j < arrays[i].length; j++) {
                pq.offer(arrays[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        
        return pq.poll();
    }
}
