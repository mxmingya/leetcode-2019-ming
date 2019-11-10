class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][n-1] == 'O') {
                dfs(board, m, n, i, n-1);
            }
            if (board[i][0] == 'O') {
                dfs(board, m, n, i, 0);
            }
        }
        
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, m, n, 0, j);
            }
            if (board[m-1][j] == 'O') {
                dfs(board, m, n, m-1, j);
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    
    void dfs(char[][] board, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n ) {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = 'B';    
        }
        
        // System.out.printf("coordinates : %d %d", i, j);
        if (i+1 < m && board[i+1][j] == 'O') {
            dfs(board, m, n, i+1, j);
        }
        if (i-1 >= 0 && board[i-1][j] == 'O') {
            dfs(board, m, n, i-1, j);
        }
        if (j+1 < n && board[i][j+1] == 'O') {
            dfs(board, m, n, i, j+1);
        }
        if (j-1 >= 0 && board[i][j-1] == 'O') {
            dfs(board, m, n, i, j-1);
        }
    }
}
