//Iteration with parent point
public class Solution {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        ParentTreeNode lca = null;
        
        List<ParentTreeNode> pathA = getPath2Root(A);
        List<ParentTreeNode> pathB = getPath2Root(B);
        int lengthA = pathA.size() - 1;
        int lengthB = pathB.size() - 1;
        
        while (lengthA >= 0 && lengthB >= 0) {
            if (pathA.get(lengthA) == pathB.get(lengthB)) {
                lca = pathA.get(lengthA);
            }
            lengthA--;
            lengthB--;
        }
        
        return lca;
    }
    
    private List<ParentTreeNode> getPath2Root (ParentTreeNode node) {
        List<ParentTreeNode> path = new ArrayList<>();
        
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        return path;
    }
}


//Recursion Same with LCA I
/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */


public class Solution {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        if (root == null || A == root || B == root) {
            return root;
        }
        ParentTreeNode left = lowestCommonAncestorII(root.left, A, B);
        ParentTreeNode right = lowestCommonAncestorII(root.right, A, B);
        
        if (left != null && right != null) {
            return root;
        }
        
        return right == null ? left : right;
    }
}
