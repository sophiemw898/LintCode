public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) {
            return false;
        }
        //1. edges == n - 1 
        if (edges.length != n - 1) {
            return false;
        }
        
        Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);
        
        //BFS
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> map = new HashSet<>();
        
        queue.offer(0);
        map.add(0);
        
        //from node 0, can find all the nodes
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (map.contains(neighbor)) {
                    continue;
                }
                map.add(neighbor);
                queue.offer(neighbor);
            }
        }
        
        return map.size() == n;
    }
    
    private Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        return graph;
    }
}
