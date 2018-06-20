public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // change to graph
        for(int[] course : prerequisites) {
            int pre = course[1];
            int cur = course[0];
            indegree[cur]++;
            graph.get(pre).add(cur);
        }
        
        //bfs
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        int[] order = new int[numCourses];
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[count++] = course;
            for (int neighbor : graph.get(course)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return (count == numCourses) ? order : new int[0];
    }
}





