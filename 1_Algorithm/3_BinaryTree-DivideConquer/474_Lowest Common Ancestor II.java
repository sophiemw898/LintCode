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
        ParentTreeNode lca = null;
        
        ArrayList<ParentTreeNode> pathA = path2root(A);
        ArrayList<ParentTreeNode> pathB = path2root(B);
        int indexA = pathA.size() - 1;
        int indexB = pathB.size() - 1;
        
        while(indexA >= 0 && indexB >=0) {
            if(pathA.get(indexA) != pathB.get(indexB)) {
                break;
            }
            lca = pathA.get(indexA);
            indexA--;
            indexB--;
        }
        
        return lca;
    }
    
    private ArrayList path2root(ParentTreeNode node) {
        ArrayList<ParentTreeNode> path = new ArrayList<>();
        while(node != null) {
            path.add(node);
            node = node.parent;
        }
        return path;
    }
}
