/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */


public class Solution {
    /*
     * @param graph: a list of Undirected graph node
     * @param s: Undirected graph node
     * @param t: Undirected graph nodes
     * @return: an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        if (s == t) {
            return 0;
        }
        
        Map<UndirectedGraphNode, Integer> isVisited = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(s);
        isVisited.put(s, 0);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode node = queue.poll();
            for (UndirectedGraphNode neighbor : node.neighbors) {
                if (isVisited.containsKey(neighbor)) {
                    continue;
                }
                isVisited.put(neighbor, isVisited.get(node) + 1);
                queue.offer(neighbor);
                
                if (neighbor == t) {
                    return isVisited.get(neighbor);
                }
            }
        }
        
        return -1;
    }
}
