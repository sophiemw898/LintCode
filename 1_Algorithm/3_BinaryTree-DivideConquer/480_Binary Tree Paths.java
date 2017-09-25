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
