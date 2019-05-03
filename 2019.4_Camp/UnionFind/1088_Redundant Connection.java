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
