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
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        // Divide Conquer
        List<String> leftpaths = binaryTreePaths(root.left);
        List<String> rightpaths = binaryTreePaths(root.right);
        
        for (String path : leftpaths) {
            paths.add(root.val + "->" + path);
        }
        for (String path : rightpaths) {
            paths.add(root.val + "->" + path);
        }
        
        //root is a leaf
        if (root.right == null && root.left == null) {
            //paths.add("" + root.val);
            paths.add(String.valueOf(root.val));
        }
        return paths;
    }
}


//Traversal

public class Solution {
    /*
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        helper(root, String.valueOf(root.val), paths);
        return paths;
    }
    
    private void helper(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            paths.add(path);
            return;
        }
        if (root.left != null) {
            helper(root.left, path + "->" + root.left.val, paths);
        }
        if (root.right != null) {
            helper(root.right, path + "->" + root.right.val, paths);
        }
    }
}
