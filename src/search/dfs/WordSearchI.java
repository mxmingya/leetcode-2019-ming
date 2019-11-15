class WordSearchI {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        int m = board.length, n = board[0].length;
        char[] chars = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                if (dfs(board, chars, visited, m, n, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean dfs(char[][] board, char[] chars, boolean[][] visited, int m, int n, int i, int j, int index) {
        if (index == chars.length) {
            return true;
        }
        if (i < 0 || i >= m|| j < 0 || j >= n || index > chars.length || visited[i][j]) {
            return false;
        }
        
        
        
        if (board[i][j] != chars[index])  {
            return false;
        }
        visited[i][j] = true;
        // board[i][j] ^= 256;
        boolean exist = dfs(board, chars, visited, m, n, i+1, j, index+1) || 
            dfs(board, chars, visited, m, n, i-1, j, index+1) || 
            dfs(board, chars, visited, m, n, i, j+1, index+1) || 
            dfs(board, chars, visited, m, n, i, j-1, index+1);
        
        visited[i][j] = false;
        // board[i][j] ^= 256;
        return exist;
    }
}
