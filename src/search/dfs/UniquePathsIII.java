class UniquePathsIII {
    public int uniquePathsIII(int[][] grid) {
        
        int[] startLocation = new int[2];
        int[] endLocation = new int[2];
        // count num of 0
        int m = grid.length, n = grid[0].length;
        int numOfZero = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    startLocation[0] = i;
                    startLocation[1] = j;
                } else if (grid[i][j] == 0) {
                    numOfZero++;
                } else if (grid[i][j] == 2) {
                    endLocation[0] = i;
                    endLocation[1] = j;
                }
            }
        }
        // System.out.printf("end location is %d %d \n", endLocation[0], endLocation[1]);
        // System.out.printf("start location is %d %d \n", startLocation[0], startLocation[1]);
        int[] res = new int[1];
        
        dfs(grid, m, n, startLocation, endLocation, startLocation[0], startLocation[1], numOfZero, res);

        return res[0];
    }

    void dfs(int[][] grid, int m, int n, int[] startLocation, int[] endLocation, int i, int j, int remainingZero, int[] res) {
        // 0 up 1 down 2 left 3 right
        if (i >= m || i < 0 || j >= n || j < 0 || grid[i][j] < 0) {
            return;
        }
        if (i == endLocation[0] && j == endLocation[1] ) {
            // System.out.println(" end location");
            if (remainingZero == 0) {
                res[0]++;
                
            }
            return;
        }
        // System.out.printf("%d, %d, %d zero left: %d\n", i, j, grid[i][j], remainingZero);
        
        grid[i][j] = -2;    
        remainingZero--;
        
        dfs(grid, m, n, startLocation, endLocation, i+1, j, remainingZero, res);
        dfs(grid, m, n, startLocation, endLocation, i-1, j, remainingZero, res);
        dfs(grid, m, n, startLocation, endLocation, i, j+1, remainingZero, res);
        dfs(grid, m, n, startLocation, endLocation, i, j-1, remainingZero, res);
        grid[i][j] = 0;    
        remainingZero++;
    }
}
