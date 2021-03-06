// 1,#,2,3 only when root.right == null && root.left == null . the node is the leaf

public class Solution {
    /**
     * @param root: The root of binary tree
     * @return: An integer
     */
    
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null || root.left == null) {
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        }
        
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}


public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }

    public int getMin(TreeNode root){
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }
}
