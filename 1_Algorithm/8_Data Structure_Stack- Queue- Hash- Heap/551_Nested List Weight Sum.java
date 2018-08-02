// 递归 dfs

public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }
    
    private int helper(List<NestedInteger> nestedList, int depth) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        int res = 0;
        for (NestedInteger curt : nestedList) {
            if (curt.isInteger()) {
                res += curt.getInteger() * depth;
            } else {
                res += helper(curt.getList(), depth + 1);
            }
        }
        
        return res;
    }
}

// 非递归 bfs
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        
        Queue<NestedInteger> queue = new LinkedList<>();
        for (NestedInteger num : nestedList) {
            queue.offer(num);
        }
        int depth = 0;
        int res = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                NestedInteger nestedInt = queue.poll();
                if (nestedInt.isInteger()) {
                    res += nestedInt.getInteger() * depth;
                } else {
                    for (NestedInteger innerInt : nestedInt.getList()) {
                        queue.offer(innerInt);
                    }
                }
            }
        }
        
        return res;
    }
}
