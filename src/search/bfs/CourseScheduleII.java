class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // construct a map using hashmap
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] order = new int[numCourses];
        int index =  0;
        int[] indegree = new int[numCourses];
        for (int[] c : prerequisites) {
            int cla = c[0], prereq = c[1];
            if (!graph.containsKey(prereq)) {
                graph.put(prereq, new LinkedList<Integer>());
            }
            graph.get(prereq).add(cla);
            indegree[cla]++;
            // System.out.printf("%d %d\n", cla, indegree[cla]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int curClass = q.poll();
            if (indegree[curClass] == 0) {
                order[index] = curClass;
                index++;
            }
            if (graph.containsKey(curClass)) {
                for (int followClass : graph.get(curClass)) {
                    indegree[followClass]--;
                    if (indegree[followClass] == 0) {
                        q.offer(followClass);
                    }
                }    
            }
        }
        return index == numCourses ? order : new int[0];
    }
    
}
