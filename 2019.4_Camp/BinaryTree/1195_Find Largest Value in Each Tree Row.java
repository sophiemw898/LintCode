/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: a root of integer
     * @return: return a list of integer
     */
    //用DFS对树进行搜索，搜索时根据当前搜索的层数，比较该层当前最大值，直至搜索完毕。
    public List<Integer> largestValues(TreeNode root) {
        // write your code here
        List<Integer> values = new ArrayList<>();
        if (root == null) {
            return values;
        }
        
        helper(root, 0, values);
        return values;
    }
    
    private void helper(TreeNode root, int level, List<Integer> values) {
        if (root == null) {
            return;
        }
        if (level == values.size()) {
            values.add(root.val);
            //level第一次出现，直接加入结果中
        } else {
            //level第二次出现，需要比较当前值和原来值， 保留最大值
            values.set(level, Math.max(root.val, values.get(level)));
        }
        
        helper(root.left, level + 1, values);
        helper(root.right, level + 1, values);
    }
}

//BFS

public class Solution {
    /**
     * @param root: a root of integer
     * @return: return a list of integer
     */
    public List<Integer> largestValues(TreeNode root) {
        // BFS
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(max);
        }
        
        return result;
    }
}
