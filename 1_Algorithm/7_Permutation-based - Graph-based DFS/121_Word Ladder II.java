//end -> start : bfs    输出所有点距离end 的位置
//start -> end : dfs 直接输出

public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> results = new ArrayList<>();
        List<String> path = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        
        dict.add(start);
        dict.add(end);
        
        bfs(graph, distance, end, start, dict);//输出每个点到end的距离
        
        dfs(graph, distance, start, end, results, path);//从start出发dfs
        
        return results;
    }
    
    private void dfs(Map<String, List<String>> graph, Map<String, Integer> distance, 
                String curr, String end, List<List<String>> results, List<String> path) {
                    path.add(curr);
                    if (curr.equals(end)) {
                        results.add(new ArrayList<String>(path));
                        path.remove(path.size() - 1);
                        return;
                    }
                    for (String nextWord : graph.get(curr)) {
                        if (distance.containsKey(nextWord) && 
                            distance.get(nextWord) + 1 == distance.get(curr)) {
                                dfs(graph, distance, nextWord, end, results, path);
                            }
                    }
                    path.remove(path.size() - 1);
                }
    
    //bfs 同时更新graph和distance 
    private void bfs(Map<String, List<String>> graph, Map<String, Integer> distance, 
                String start, String end, Set<String> dict) {
                    Queue<String> queue = new LinkedList<>();
                    queue.offer(start);
                    distance.put(start, 0);
                    for (String word : dict) {
                        graph.put(word, new ArrayList<String>());
                    }
                    while (!queue.isEmpty()) {
                        String curr = queue.poll();
                        for (String nextWord : getNextWords(dict, curr)) {
                            graph.get(curr).add(nextWord);
                            if (!distance.containsKey(nextWord)) {
                                distance.put(nextWord, distance.get(curr) + 1);
                                queue.offer(nextWord);
                            }
                        }
                    }
                }
                
    private List<String> getNextWords(Set<String> dict, String curr) {
        List<String> nextWords = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < curr.length(); i++) {
                if (curr.charAt(i) == c) {
                    continue;
                }
                String nextWord = curr.substring(0, i) + c + curr.substring(i + 1);
                if(dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        
        return nextWords;
    }
}



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
