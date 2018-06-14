//Same with Leedcode Better
Here I use typical BFS method to handle a binary tree. I use string n to represent null values. The string of the binary tree in the example will be "1 2 3 n n 4 5 n n n n ".

When deserialize the string, I assign left and right child for each not-null node, and add the not-null children to the queue, waiting to be handled later.

public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}


//Same with JIUzhang**********************************************************************
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
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        
        //transfer from Tree to List;
        //[3,9,20,null,null,15,7,null,null,null,null]
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        
        //remove all null in the end to get [3,9,20,null,null,15,7]
        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }
        
        //transfer from List to String
        //get{3,9,20,#,#,15,7}
        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i) == null) {
                result.append(",#");
            } else {
                result.append(",");
                result.append(queue.get(i).val);
            }
        }
        result.append("}");
        
        return result.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data.equals("{}")) {
            return null;
        }
        // data {3,9,20,#,#,15,7}
        String[] vals = data.substring(1, data.length() - 1).split(",");
        
        System.out.println(vals);
        
        ArrayList<TreeNode> queue = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        
        int index = 0;
        boolean isLeftChild = true;
        
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }        
            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        
        return root;
    }
}
