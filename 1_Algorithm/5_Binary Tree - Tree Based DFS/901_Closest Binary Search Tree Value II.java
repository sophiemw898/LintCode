//最优算法，时间复杂度 O(k + logn)O(k+logn)，空间复杂度 O(logn)O(logn)

//实现如下的子函数：

//getStack() => 在假装插入 target 的时候，看看一路走过的节点都是哪些，放到 stack 里，用于 iterate。最后停的点是离target最近的child之一
//moveUpper(stack) => 根据 stack，挪动到 next node
//moveLower(stack) => 根据 stack, 挪动到 prev node
//有了这些函数之后，就可以把整个树当作一个数组一样来处理，只不过每次 i++ 的时候要用 moveUpper，i--的时候要用 moveLower

public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        if (k == 0) {
            return result;
        }
        
        Stack<TreeNode> lowerStack = getStack(root, target);
        Stack<TreeNode> upperStack = new Stack<>();
        upperStack.addAll(lowerStack);
        
        if (target > lowerStack.peek().val) {
            moveUpper(upperStack);
        } else {
            moveLower(lowerStack);
        }
        
        for (int i = 0; i < k; i++) {
            if ( (lowerStack.empty())|| (!upperStack.empty()) && (upperStack.peek().val - target < target - lowerStack.peek().val)) {
                result.add(upperStack.peek().val);
                moveUpper(upperStack);
            } else {
                result.add(lowerStack.peek().val);
                moveLower(lowerStack);
            }
        }
        
        return result;
    }
    
    //getStack() => 在假装插入 target 的时候，看看一路走过的节点都是哪些，放到 stack里，用于 iterate。最后停的点是离target最近的child之一
    private Stack<TreeNode> getStack(TreeNode root, double target) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.add(root);
            
            if (target > root.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return stack;
    }
    
    //moveUpper(stack) => 根据 stack，挪动到 next node
    private void moveUpper(Stack<TreeNode> stack) {
        TreeNode node = stack.peek();
        if (node.right == null) {
            node = stack.pop();
            while (!stack.empty() && stack.peek().right == node) {
                node = stack.pop();
            }
        } else {
            node = node.right;
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
        }
    }
    
    //moveLower(stack) => 根据 stack, 挪动到 prev node
    private void moveLower(Stack<TreeNode> stack) {
        TreeNode node = stack.peek();
        if (node.left == null) {
            node = stack.pop();
            while (!stack.empty() && stack.peek().left == node) {
                node = stack.pop();
            }
        } else {
            node = node.left;
            while (node != null) {
                stack.add(node);
                node = node.right;
            }
        }
    }
}

//暴力方法。时间复杂度 O(n)O(n)，空间复杂度也是 O(n)O(n)

//先用 inorder traversal 求出中序遍历
//找到第一个 >= target 的位置 index
//从 index-1 和 index 出发，设置两根指针一左一右，获得最近的 k 个整数
public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> values = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        
        //先用 inorder traversal 求出中序遍历
        traverse(root, values);
        
        //找到第一个 >= target 的位置 index
        int i = 0;
        for (i = 0; i < values.size(); i++) {
            if (values.get(i) >= target) {
                break;
            }
        }
        
        if (i == values.size()) {
            return values.subList(values.size() - k, values.size());
        }
        
        //从 index-1 和 index 出发，设置两根指针一左一右，获得最近的 k 个整数
        int left = i - 1, right = i;
        for (int j = 0; j < k; j++) {
            if (left >= 0 && (right >= values.size() || values.get(right) - target >= target - values.get(left))) {
                result.add(values.get(left));
                left--;
            } else {
                result.add(values.get(right));
                right++;
            }
        }
        
        return result;
    }
    
    private void traverse(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }
        traverse(root.left, values);
        values.add(root.val);
        traverse(root.right, values);
    }
}
