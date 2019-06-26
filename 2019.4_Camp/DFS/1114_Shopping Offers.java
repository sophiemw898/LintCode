//易懂的dfs写法
public class Solution {
    /**
     * @param price: List[int]
     * @param special: List[List[int]]
     * @param needs: List[int]
     * @return: return an integer
     */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return dfs(price, special, needs, 0, memo);
    }
    
    //helper返回得到needs的最小花费 同时记录在memo里面
    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos, Map<List<Integer>, Integer> memo) {
        //计算过同样的needs，返回即可
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }
        
        int minCost = directBuy(price, needs);
        for (int i = pos; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            List<Integer> tempNeeds = new ArrayList<>();
            //check if current offer is valid
            for (int j = 0; j < offer.size() - 1; j++) {
                if (needs.get(j) < offer.get(j)) {
                    tempNeeds = null;
                    break;
                }
                tempNeeds.add(needs.get(j) - offer.get(j));
            }
            
            //use the current offer and try next 
            if (tempNeeds != null) {
                minCost = Math.min(minCost, 
                offer.get(offer.size() - 1) + dfs(price, special, tempNeeds, i, memo));
            }
        }
        
        //update minCost to memo
        memo.put(needs, minCost);
        return minCost;
    }
    
    private int directBuy(List<Integer> price, List<Integer> needs) {
        int cost = 0;
        for (int i = 0; i < price.size(); i++) {
            cost += price.get(i) * needs.get(i);
        }
        return cost;
    }
}

public class Solution {
    /**
     * @param price: List[int]
     * @param special: List[List[int]]
     * @param needs: List[int]
     * @return: return an integer
     */
    //对于每一种促销方案，先判断能否选用，如果超过需要额度则不可以选用，对于可以选用的，用dp，转移方程为result = min(result , shoppingOffers(price, special, needs) + offer.get(offer.size() - 1)) 
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // write your code here
        int res = 0;
        //count the maximun value of const
        for (int i = 0; i < price.size(); i++) {
            res += price.get(i) * needs.get(i);
        }
        
        //遍历所有offer
        for (int i = 0; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            Boolean isValid = true;
            //[2,2,1,9] [1,2,1]
            //通过算较need，先确认offer是否可用 
            for (int j = 0; j < offer.size() - 1; j++) {
               if (offer.get(j) > needs.get(j)) {
                   isValid = false;
               } 
               
               //若offer可用，更新needs
               needs.set(j, needs.get(j) - offer.get(j));
            }
            //dp计算使用当前offer的res
            if (isValid) {
                res = Math.min(res, (shoppingOffers(price, special, needs) + offer.get(offer.size() - 1)));
            }
            
            //恢复到不实用offer的状态，尝试下一个offer
            for (int j = 0; j < offer.size() - 1; j++) {
               needs.set(j, needs.get(j) + offer.get(j));
            }
        }

        return res;
    }
}
