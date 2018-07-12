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
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> results = new ArrayList<>();
        ArrayList<Integer> buffer = new ArrayList<>();
        if (root == null) {
            return results;
        }
        findSum(root, target, buffer, results);
        return results;
    }
    
    private void findSum(TreeNode root, int target, ArrayList<Integer> buffer, List<List<Integer>> results) {
        //1.递归的出口
        if (root == null) {
            return;
        }
        //2.递归的拆解
        buffer.add(root.val);
        int sum = 0;
        for (int i = buffer.size() - 1; i >= 0; i--) {
            sum += buffer.get(i);
            if (sum == target) {
                //results.add(new ArrayList<Integer>(buffer.subList(i, buffer.size())));  
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j = i; j < buffer.size(); j++) {
                    temp.add(buffer.get(j));
                }
                results.add(temp);
            }
        }

        findSum(root.left, target, buffer, results);
        findSum(root.right, target, buffer, results);
        buffer.remove(buffer.size() - 1);
    }
//这道题最容易犯的错误就是，从每个节点新开始一个搜索，这样会在树的末端大量重复，而且这种重复没法用Set消除，因为可能存在多条路径整数序列一样。
}
