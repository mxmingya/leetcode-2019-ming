class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        
        class Node {
            int i;
            int j;
            public Node(int i, int j) {
                this.i = i;
                this.j = j;
            }
        }
        
        int index = 0;
        PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2) {
                return matrix[n1.i][n1.j] - matrix[n2.i][n2.j];
            }
        });
        
        q.offer( new Node(0,0));
        while (!q.isEmpty()) {
            Node c = q.poll();
            
            // System.out.println(matrix[c.i][c.j]);
            index++;
            if (index >= k) {
                return matrix[c.i][c.j];
            }
            
            if (c.i + 1 < m && c.j < n) {
                if (!visited[c.i + 1][c.j]) {
                    q.offer(new Node(c.i +1, c.j));  
                    visited[c.i + 1][c.j] = true;
                }
                
            }
            if (c.i < m && c.j + 1 < n) {
                if (!visited[c.i][c.j + 1]) {
                    q.offer(new Node(c.i, c.j + 1)); 
                    visited[c.i][c.j + 1] = true;
                }
            }
        }
        return matrix[m-1][n-1];
    }
}
