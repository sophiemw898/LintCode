public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> dist = new HashMap<>();
        dict.add(start);
        dict.add(end);
        
        //Create graph;
        bfs(start, end, dict, graph, dist);
        /*
        System.out.println(graph.size());
        for (String s : dist.keySet()) {
            System.out.println(s + " " + dist.get(s));
        }
        */
        
        //Search in the graph using dfs;
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(res, path, graph, dist, start, end);
        
        return res;
    }
    
    private void bfs(String start, String end, Set<String> dict,
                        Map<String, List<String>> graph, Map<String, Integer> dist) {
        
        Deque<String> queue = new ArrayDeque<>();
        queue.offerLast(start);
        dist.put(start, 0);
        
        while (!queue.isEmpty()) {
            String curr = queue.pollFirst();
            List<String> neighbors = getNeighbors(curr, dict);
            graph.put(curr, new ArrayList<>(neighbors));
            for (String next : neighbors) {
                if (dist.containsKey(next)) {
                    continue;
                }
                queue.offerLast(next);
                dist.put(next, dist.get(curr) + 1);
            }
        }
    }
    
    private List<String> getNeighbors(String curr, Set<String> dict) {
        List<String> neighbors = new ArrayList<>();
        char[] cur = curr.toCharArray();
        for (int i = 0; i < cur.length; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == cur[i]) {
                    continue;
                }
                char orig = cur[i];
                cur[i] = ch;
                if (dict.contains(String.valueOf(cur))) {
                    neighbors.add(String.valueOf(cur));
                }
                cur[i] = orig;
            }
        }
        /*        
        System.out.print(curr + ": ");
        for (String s : neighbors) {
            System.out.print(s + " ");
            System.out.println();
        }*/
        return neighbors;
    }
    
    private void dfs(List<List<String>> res, List<String> path, 
                        Map<String, List<String>> graph, Map<String, Integer> dist,
                        String curr, String end) {
        path.add(curr);
        if (curr.equals(end)) {
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        
        for (String next : graph.get(curr)) {
            if (dist.get(next) == dist.get(curr) + 1) {
                dfs(res, path, graph, dist, next, end); 
            }
        }
        path.remove(path.size() - 1);
    }
}
