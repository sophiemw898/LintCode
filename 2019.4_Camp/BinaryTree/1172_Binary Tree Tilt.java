
public class Solution {
    /**
     * @param root: the root
     * @return: the tilt of the whole tree
     */
    // 需要随时计算当前节点的和 helper()
    int res = 0;
    public int findTilt(TreeNode root) {
        // Write your code here
        helper(root);
        return res;
    }
    
    //use helper() to count sum of all subtree node valus
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        res += Math.abs(right - left);
        return left + right + root.val;
    }
}

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
     * @param root: the root
     * @return: the tilt of the whole tree
     */
    // 我们发现求树的倾斜程度的时候我们需要统计子树的权值和，所以我们可以在递归求解子树权值和的过程中一起把答案返回即可。
    public int findTilt(TreeNode root) {
        // Write your code here
        return countSum(root)[1];
    }
    
    //use helper() to count sum of all subtree node valus and tilt
    private int[] countSum(TreeNode root) {
        if (root == null) {
            return new int[]{0,0};
        }
        //array[0] define sum
        //array[1] define dif of all nodes _ the tile of the whole tree
        int[] l = countSum(root.left);
        int[] r = countSum(root.right);
        return new int[] {root.val + l[0] + r[0], 
                        l[1] + r[1] + Math.abs(l[0] - r[0])};
    }
}
