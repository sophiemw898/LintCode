1. 首先思考使用暴力方式解决问题，我们穷举那条需要删除的边，然后都过深度优先搜索（dfs）验证删完之后的图是否为一棵树，时间复杂度是O(n^2)，虽然已经不错了，但这不是面试官预期的时间复杂度
2. 我们换个思路考虑，遍历所有边，一边遍历一边将当前边加入到图中。如果我们发现，有一条边[u,v]还未曾加入到图中时，u和v就已经通过其他若干边相连，那么这就是我们要找的“多余”的边。
3. 如果我们还是用dfs去判断u和v的连通性，那么是O(n)的时间复杂度，总的时间复杂度仍是O(n^2)。这里我们就要用到一种数据结构叫做并查集，可以在常数时间内两个元素是否在同一集合（查询操作）和把两个元素合并到同一个集合（合并操作）。在并查集中，每个集合都有一个代表元素，我们称之为祖先。
4. 并查集的初始化：在最初的时候，根节点都是自己，我们用一个数组parent[i]=i来表示这个关系。
5. 并查集的查询操作：每次给边的时候判断两个点的祖先节点，我们不停地通过调用parent函数向上寻找直到parent[i]==i
6. 给出一条边，两个节点设置为l ,r 如果祖先节点father_l, father_r 不相同，说明此时l和r不向连，这条边信息有用（不是一条多余的边），我们就通过并查集的合并操作将他们连在一起**。**具体操作需要将祖先节点接在一起，令parent[father_r]=father_l。
7. 路径压缩优化：在做查询操作的时候我们将parent[now] = find_father(parent[now])，是为了压缩路径，因为一旦两棵树合并，其中一些节点不是直接指向根节点的，不合并每次搜索会浪费大量时间
8. 我们认为总的时间复杂度是O(n)，其中使用了路径压缩的并查集的常数非常小可以忽略
9. 虽然题目强调如果有多个答案输出最后一条，但用上述方法只会找到一条“多余”的边，所以代码中是从前往后遍历所有边

public class Solution {
    /**
     * @param edges: List[List[int]]
     * @return: List[int]
     */
    private int[] father = null;
    
    private int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] =  find(father[x]);
    }
    
    private void connect(int a, int b) {
        int fatherA = find(a);
        int fatherB = find(b);
        
        if (fatherA != fatherB) {
            father[fatherA] = fatherB;
        }
    }
    
    //遍历不相连则加入集合，相连的话就保存为结果，不加入
    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        //initialization
        father = new int[edges.length + 1];
        for (int i = 1; i <= edges.length; i++) {
            father[i] = i;
        }
        
        for (int[] edge : edges) {
            int left = edge[0];
            int right = edge[1];
            //相连的话就保存为结果，不加入
            if (find(left) == find(right)) {
                res[0] = left;
                res[1] = right;
            } else {
                //遍历不相连则加入集合
                connect(left, right);
            }
        }
        
        return res;
    }
}
