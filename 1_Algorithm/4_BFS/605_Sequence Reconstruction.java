public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        
        for (int point : org) {
            graph.put(point, new HashSet<Integer>());
            indegree.put(point, 0);
        }
        
        int count = 0;
        for (int[] seq : seqs) {
            count += seq.length;
            if (seq.length >= 1 && (seq[0] <= 0 || seq[0] > org.length)) {
                return false;// [1] [[] []]
            }
            for (int i = 1; i < seq.length; i++) {
                if (seq[i] <= 0 || seq[i] > org.length) {
                    return false;
                }
                if (!graph.get(seq[i - 1]).contains(seq[i])) {
                    graph.get(seq[i - 1]).add(seq[i]);
                    indegree.put(seq[i], indegree.get(seq[i]) + 1);
                }
            }
        }
        
        // case [1] []
        if (org.length > count) {
            return false;
        }
        
        //bfs
        Queue<Integer> queue = new LinkedList<>();
        
        for (int key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.offer(key);
            }
        }
        //since uniquely, can't have two number with indegree = 0 at one time
        int cnt = 0;
        while (queue.size() == 1) {
            int num = queue.poll();
        
            for (int neighbor : graph.get(num)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
            
            if (org[cnt] != num) {
                return false;
            }
            
            cnt++;
        }
        
        return cnt == org.length;
    }
}
