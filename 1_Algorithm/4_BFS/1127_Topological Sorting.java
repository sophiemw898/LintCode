/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        if (graph == null) {
            return result;
        }
        
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();
        //count indegree 入度 找到进入该点需要解锁的点 起始点入度值 = 0
        for (DirectedGraphNode node : graph) {
            indegree.put(node, 0); 
        }
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                //node -> neighbor
                indegree.put(neighbor,indegree.get(neighbor) + 1);
            }
        }
        
        //bfs
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        //初始化 put all start nodes in queue
        for (DirectedGraphNode node : graph) {
            if (indegree.get(node) == 0) {
                queue.offer(node);
                result.add(node);
            }
        }
        
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor : node.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                    result.add(neighbor);  
                }
            }
        }
        
        return result;
    }
}
