/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        List<List<Integer>> results = new ArrayList<>();
        if (nodes == null) {
            return results;
        }
        
        Map<UndirectedGraphNode, Boolean> visited = new HashMap<>();
        
        for (UndirectedGraphNode node : nodes) {
            visited.put(node, false);
        }
        
        for (UndirectedGraphNode node : nodes) {
            if (visited.get(node)) {
                continue;
            }
            bfs(node, results, visited);
        }
        
        return results;
    }
    
    private void bfs (UndirectedGraphNode node, List<List<Integer>> results, Map<UndirectedGraphNode, Boolean> visited) {
        List<Integer> res = new ArrayList<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        visited.put(node, true);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode curt = queue.poll();
            res.add(curt.label);
            for (UndirectedGraphNode neighbor : curt.neighbors) {
                if (visited.get(neighbor)) {
                    continue;
                }
                visited.put(neighbor, true);
                queue.offer(neighbor);
            }
        }
        
        Collections.sort(res);//sort
        results.add(res);
    }
}
