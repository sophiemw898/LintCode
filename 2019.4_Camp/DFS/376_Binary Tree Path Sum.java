//O(N) 所有点走了一遍
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
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        dfs(root, path, root.val, target, res);
        return res;
    }
    
    private void dfs(TreeNode root, List<Integer> path, int sum, int target, List<List<Integer>> res) {
        if (root.right == null && root.left == null) {
            if (sum == target) {
                res.add(new ArrayList<Integer>(path));
            }
            return;
        }
        
        if (root.left != null) {
            path.add(root.left.val);
            dfs(root.left, path, sum + root.left.val, target, res);
            path.remove(path.size() - 1);
        }
        
        if (root.right != null) {
            path.add(root.right.val);
            dfs(root.right, path, sum + root.right.val, target, res);
            path.remove(path.size() - 1);
        }
    }
}
