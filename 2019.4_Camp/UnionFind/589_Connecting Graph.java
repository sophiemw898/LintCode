public class ConnectingGraph {
    /*
    * @param n: An integer
    */
    private int[] father = null;
    //private int[] size = null;
    
    private int find (int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    
    public ConnectingGraph(int n) {
        // do intialization if necessary
        father = new int[n + 1];
        //size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            father[i] = i;
            //size[i] = 1;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        int fatherA = find(a);
        int fatherB = find(b);
        if (fatherB != fatherA) {
            father[fatherA] = fatherB;
            //size[fatherB] += fatherA;
        }
    }
    
    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        int fatherA = find(a);
        int fatherB = find(b);
        return fatherA == fatherB;
    }
    
    /*//caculate the size of each union
    private int query2(int a) {
        return size[a];
    }    
    */
}
