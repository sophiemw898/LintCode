public class ConnectingGraph {
    /*
    * @param n: An integer
    */
    private int[] father = null;
    
    public ConnectingGraph(int n) {
        // do intialization if necessary
        father = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            father[i] = i;
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
    
    private int find (int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }
}
