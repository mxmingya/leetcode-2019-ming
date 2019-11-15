class findWords {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();
        if (board == null || board.length == 0 || words == null) {
            return res;
        }
        int m = board.length, n = board[0].length;
        HashSet<String> wordSet = new HashSet<>();

        for (String word : words) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(res, board, word, m, n, i, j, 0, new boolean[m][n])) {
                        wordSet.add(word);
                    }
                }
            }
        }
        for (String word : wordSet) {
            res.add(word);
        }
        return res;
    }
    
    boolean dfs(List<String> res, char[][] board, String word, int m, int n, int i, int j, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            // System.out.printf("%d %d\n", i, j);
            return false;
        }
        
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean found = dfs(res, board, word, m, n, i+1, j, index+1, visited) ||
            dfs(res, board, word, m, n, i-1, j, index+1, visited) ||
            dfs(res, board, word, m, n, i, j+1, index+1, visited) ||
            dfs(res, board, word, m, n, i, j-1, index+1, visited);
        visited[i][j] = false;
        return found;
    }
}
