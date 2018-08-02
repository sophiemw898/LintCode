//PriorityQueue
public class Solution {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        //top k in pq size() = k

        int[] res = new int[k];
        int i = k - 1;
        while (!pq.isEmpty()) {
            res[i--] = pq.poll();
        }
        
        return res;
    }
}

//minheap
public class Solution {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        
        for (int num : nums) {
            minheap.offer(num);
            if (minheap.size() > k) {
                minheap.poll();
            }
        }
        //top k in pq size() = k

        int[] res = new int[k];
        int i = k - 1;
        while (!minheap.isEmpty()) {
            res[i--] = minheap.poll();
        }
        
        return res;
    }
}
