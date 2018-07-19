public class Solution {
    /**
     * @param stones: a list of stones' positions in sorted ascending order
     * @return: true if the frog is able to cross the river or false
     */
    public boolean canCross(int[] stones) {
        //设f[i][j]表示是否能最后一跳j跳到石头ai
        //boolean[][] f = new boolean[][];
        //设上一块石头是ak=ai-j，可以通过一个哈希表(ak, k)快速找到k
        //f[i][j] = f[k][j-1] OR f[k][j] OR f[k][j+1] | ak=ai-j
        
        //use HashMap<Ak, k> to restore 能通过k步到达Ak点
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            dp.put(stones[i], new HashSet<Integer>());  
        }
        
        dp.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            for (int k : dp.get(stone)) {
                //k - 1
                if (k - 1 > 0 && dp.containsKey(stone + k - 1)) {
                    dp.get(stone + k - 1).add(k - 1);
                }
                //k
                if (dp.containsKey(stone + k)) {
                    dp.get(stone + k).add(k);
                }
                //k + 1
                if (dp.containsKey(stone + k + 1)) {
                    dp.get(stone + k + 1).add(k + 1);
                }
            }
        }
        
        return !dp.get(stones[stones.length - 1]).isEmpty();
    }
}
