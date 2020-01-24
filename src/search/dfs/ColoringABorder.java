class ColoringABorder {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if (grid.length == 0 ) {
            return grid;
        }
        int m = grid.length, n = grid[0].length;
        dfs(grid, r0, c0, m, n, grid[r0][c0]);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // System.out.printf("%d %d ", i, j);
                if (grid[i][j] < 0) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }
    
    public void dfs(int[][] grid, int i, int j, int m, int n, int preColor) {
        // System.out.printf("%d %d ", i, j);
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != preColor) {
            // System.out.printf("%d, %d ", grid[i][j], preColor);
            return;
        } 
        
        grid[i][j] = 0-preColor;
        // System.out.printf("%d %d ", i, j);
        dfs(grid, i+1, j, m, n, preColor);
        dfs(grid, i-1, j, m, n, preColor);
        dfs(grid, i, j+1, m, n, preColor);
        dfs(grid, i, j-1, m, n, preColor);
        if (i > 0 && j > 0 && i < m-1 && j < n-1 && 
           preColor == Math.abs(grid[i+1][j]) && 
           preColor == Math.abs(grid[i-1][j]) && 
            preColor == Math.abs(grid[i][j+1]) && 
            preColor == Math.abs(grid[i][j-1])
           ) {
            grid[i][j] = preColor;
        }
    }
}
