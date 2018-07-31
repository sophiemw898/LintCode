// version 2 O(nlogn) HashMap + Heap

public class Solution {
    /**
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // if (n == 1) {
        //     return 1;
        // }
        
        Queue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        
        Long[] factors = new Long[3];
        factors[0] = Long.valueOf(2);
        factors[1] = Long.valueOf(3);
        factors[2] = Long.valueOf(5);
        
        for (int i = 0; i < 3; i++) {
            queue.add(factors[i]);
            set.add(factors[i]);
        }
        
        Long number = Long.valueOf(1);
        for (int i = 1; i < n; i++) {
            number = queue.poll();
            for (int j = 0; j < 3; j++) {
                if (!set.contains(factors[j] * number)) {
                    queue.add(factors[j] * number);
                    set.add(factors[j] * number);
                }
            }
        }
        
        return number.intValue();
    }
}
