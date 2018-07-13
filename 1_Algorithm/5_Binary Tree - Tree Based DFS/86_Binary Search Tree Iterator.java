//这是一个非常通用的利用 stack 进行 Binary Tree Iterator 的写法。

//stack 中保存一路走到当前节点的所有节点，stack.peek() 一直指向 iterator 指向的当前节点。
//因此判断有没有下一个，只需要判断 stack 是否为空
//获得下一个值，只需要返回 stack.peek() 的值，并将 stack 进行相应的变化，挪到下一个点。

//挪到下一个点的算法如下：

//如果当前点存在右子树，那么就是右子树中“一路向西”最左边的那个点
//如果当前点不存在右子树，则是走到当前点的路径中，第一个左拐的点

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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */


public class BSTIterator {
    
    private Stack<TreeNode> stack = new Stack<>();
    /*
    * @param root: The root of binary tree.
    */
    //Initialization point to the first num should be pop
    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    /*
     * @return: True if there has next node, or false
     */
    //stack 中保存一路走到当前节点的所有节点，stack.peek() 一直指向 iterator指向的当前节点。
    //因此判断有没有下一个，只需要判断 stack 是否为空
    public boolean hasNext() {
        return !stack.empty();
    }

    /*
     * @return: return next node
     */
    //获得下一个值，只需要返回 stack.peek() 的值，并将 stack 进行相应的变化，挪到下一个点。
    //挪到下一个点的算法如下：
    //如果当前点存在右子树，那么就是右子树中“一路向西”最左边的那个点
    //如果当前点不存在右子树，则是走到当前点的路径中，第一个左拐的点

    public TreeNode next() {
        TreeNode curt = stack.peek();
        TreeNode node = curt;//used for update stack;
        if (node.right == null) {
            node = stack.pop();
            //下面条件成立说明node是在前一点的右子树上，前一个点已经写入，将其弹出
            while (!stack.empty() && stack.peek().right == node) {
                node = stack.pop();
            }
        } else {
            node = node.right;
            while (node!= null) {
                stack.add(node);
                node = node.left;
            }
        }
        
        return curt;
    }
}
