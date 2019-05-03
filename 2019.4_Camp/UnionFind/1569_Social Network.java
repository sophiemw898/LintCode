public class Solution {
    /**
     * @param n: the person sum
     * @param a: the array a
     * @param b: the array b
     * @return: yes or no
     */
    
    //数组记录每次更新的点的祖先
    private int[] father = null;
    private int count;
    
    //查找点的当前的father，每次更新记录father[] 不然每次find最坏都是O(n)
    private int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    
    //合并关系更新father，count--
    private void connect(int a, int b) {
        int fatherA = find(a);
        int fatherB = find(b);
        if (fatherB != fatherA) {
            //每次更新是当前祖先的更新，不是ab本身
            father[fatherA] = fatherB;
             count--;
        }
    }
    
    public String socialNetwork(int n, int[] a, int[] b) {
        //UnionFind
        //对于每对关系建边，做并查集。若两个点拥有共同的祖先，代表这两个点能够相互联系。最后，若所有的人都只有同一个共同的祖先，则代表所有的人能够相互联系。
        //初始化
        father = new int[n + 1];
        count = n;
        for (int i = 1; i <= n; i++) {
            father[i] = i;
        }
        //遍历每对关系，依次合并两点，更新father
        for (int i = 0; i < a.length; i++) {
            connect(a[i], b[i]);
        }
        //count = 1 说明成功合并了n-1从，所有都在一个集里面 
        if (count == 1) {
            return "yes";
        } else {
            return "no";
        }
    }
}
