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
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return Math.max(left, right) + 1;
    }
}


public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    //dfs
    int res = 0;
    public int maxDepth(TreeNode root) {
        helper(root, 1);
        return res;
    }
    
    private void helper(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        res = Math.max(res, depth);
        
        helper(node.right, depth + 1);
        helper(node.left, depth + 1);
    }
}

//BFS
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
     
    //bfs
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //first last记录当前层的首位和尾位
        int first = 0, last = 1;
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            first++;
            
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            
            //when depth++
            if (first == last) {
                depth++;
                first = 0;
                last = queue.size();
            }
        }
        
        return depth;
    }
}
