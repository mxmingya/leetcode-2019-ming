package search.bfs;


class PossibleBipartite {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if (N == 0 || dislikes == null || dislikes.length == 0) {
            return true;
        }

        int size = dislikes.length;
        int[][] graph = new int[N][N];
        int[] group = new int[N];
        for (int[] pair : dislikes) {
            int p1 = pair[0]-1, p2 = pair[1]-1;
            graph[p1][p2] = 1;
            graph[p2][p1] = 1;
        }
        // graph[p1][p2] means p1 and p2 dislikes each other. 
        // group[i]=1 means i is at group 1, group[-i] means i is at group 2
        for (int i = 0; i < N; i++) {
            // if i is unassigned, assign i to a group either 1 or 0
            if (group[i] == 0 && !ifPersonValid(graph, i, group, 1)) {
                return false;
            }
        }

        return true;
    }

    boolean ifPersonValid(int[][] graph, int dislikedPerson, int[] group, int flag) {
        group[dislikedPerson] = flag;
        for (int person = 0; person < graph.length; person++) {
            if (graph[person][dislikedPerson] == 1) // if two person hate each other, assign them to different group, 
            {
                if (group[person] == flag) {
                    return false;
                }
                // if current person is unassigned in the liking group
                if (group[person] == 0 && !ifPersonValid(graph, person, group, -flag)) {
                    return false;
                }
            }
        }
        return true;
    }
}