//时间复杂度 O(n)O(n) 最好最坏都是。
//算法思想类似于 Quick Select。
//这个算法的好处是，如果多次查询的话，给每个节点统计儿子个数这个过程只需要做一次。查询可以很快。

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
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        Map<TreeNode, Integer> childrenNum = new HashMap<>();
        countNodes(root, childrenNum);
        return quickSelectOnTree(root, k, childrenNum);
    }
    
    //update Map
    private int countNodes(TreeNode root, Map<TreeNode, Integer> childrenNum) {
        if (root == null) {
            return 0;
        }
        int left = countNodes(root.left, childrenNum);
        int right = countNodes(root.right, childrenNum);
        
        childrenNum.put(root, left + right + 1);
        return left + right + 1;
    }
    
    private int quickSelectOnTree(TreeNode root, int k, Map<TreeNode, Integer> childrenNum) {
        if (root == null) {
            return 0;
        }
        
        //{1,#,2} 2 if left == null, no key-value in map
        int left = root.left == null ? 0 : childrenNum.get(root.left);
        
        if (k <= left) {
            return quickSelectOnTree(root.left, k, childrenNum);
        }
        if (k == left+ 1) {
            return root.val;
        }
        return quickSelectOnTree(root.right, k - left - 1, childrenNum);
    }
}
