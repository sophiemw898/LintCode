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

//使用 Binary Search Tree Iterator 的方式（可以参考 binary search tree iterator 那个题）
//用 stack，从第一个点开始，走 k-1 步，就是第 k 个点了。
//时间复杂度是 O(h + k)O(h+k) h 是树的高度。
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
        Stack<TreeNode> stack =  new Stack<>();
        TreeNode cur = root;
        
        //Initialization. point to 1st node should be pop
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        
        //获得下一个值，只需要返回stack.peek()的值，并将stack 进行相应的变化，挪到下一个点。
        //重复k-1次next（）指令， 第k次看到的点即为kthSmallest
        for (int i = 0; i < k - 1; i++) {
            //used for update stack;
            TreeNode node = stack.peek();
            if (node.right == null) {
                node = stack.pop();
                //下面条件成立说明node是在前一点的右子树上，前一个点已经写入，将其弹出
                while (!stack.empty() && stack.peek().right == node) {
                    node = stack.pop();
                }
            } else {
                //如果当前点存在右子树，那么就是右子树中“一路向西”最左边的那个点
                node = node.right;
                while (node != null) {
                    stack.add(node);
                    node = node.left;
                }
            }
        }
        
        return stack.peek().val;
    }
}
