//DFS
public class Solution {
    /**
     * @param root: the root of the binary tree
     * @param level: the depth of the target level
     * @return: An integer
     */
    int sum = 0;
    public int levelSum(TreeNode root, int level) {
        helper(root, 1, level);
        return sum;
    }
    
    //calculate the sum when depth == level
    private void helper(TreeNode root, int depth, int level) {
        if (root == null) {
            return;
        }
        if (depth == level) {
            sum += root.val;
        }
        
        helper(root.left, depth + 1, level);
        helper(root.right, depth + 1, level);
    }
}

//Divede & conquer
public class Solution {
    /**
     * @param root: the root of the binary tree
     * @param level: the depth of the target level
     * @return: An integer
     */
    public int levelSum(TreeNode root, int level) {
        // write your code here
        if (root == null) {
            return 0;
        }
        
        if (level == 1) {
            return root.val;
        }
        
        if (level > 1) {
            return levelSum(root.left, level - 1) + levelSum(root.right, level - 1);
        }
        
        return 0;
    }
}

//BFS
public class Solution {
    /**
     * @param root: the root of the binary tree
     * @param level: the depth of the target level
     * @return: An integer
     */
    public int levelSum(TreeNode root, int level) {
        // BFS
        if (level <= 0 || root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (level > 1) {
            level--;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                 
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        
        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res += node.val;
        }
        return res;
    }
}
