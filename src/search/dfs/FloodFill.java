class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return new int[0][0];
        }
        
        int color = image[sr][sc];
        
        boolean[][] visited = new boolean[image.length][image[0].length];
        
        dfs(image, sr, sc, image.length, image[0].length, image[sr][sc], newColor, visited);
        
        
        return image;
    }
    
    void dfs(int[][] image, int i, int j, int m, int n, int preColor, int newColor, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || image[i][j] != preColor || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        
        image[i][j] = newColor;
        dfs(image, i+1, j, m, n, preColor, newColor, visited);
        dfs(image, i-1, j, m, n, preColor, newColor, visited);
        dfs(image, i, j+1, m, n, preColor, newColor, visited);
        dfs(image, i, j-1, m, n, preColor, newColor, visited);
    }
}
