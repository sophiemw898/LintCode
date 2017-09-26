
O(N)
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

//recursion traverse
public class Solution {
    /*
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        traverse(results, root);
        return results;
    }
    //递归的定义：把root为根的preorder加入到result里
    private void traverse(List<Integer> results, TreeNode root) {
        // 递归的出口
        if (root == null) {
            return;
        }
        // 递归的拆解 
        results.add(root.val);
        traverse(results, root.left);
        traverse(results, root.right);
    }
}

//recursion Divide Conquer
public class Solution {
    /*
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        //Divede
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        //Conquer
        results.add(root.val);
        results.addAll(left);
        results.addAll(right);
        
        return results;
    }
}
        
//recursion iteration

public class Solution {
    /*
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.removeFirst();
            results.add(cur.val);
            if (cur.right != null) {
                stack.addFirst(cur.right);
            }
            if (cur.left != null) {
                stack.addFirst(cur.left);
            }
        }
        
        return results;
    }
}
