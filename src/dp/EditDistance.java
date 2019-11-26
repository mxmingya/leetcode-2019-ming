class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1.length() ==  0 || word2.length() == 0) {
            return Math.abs(word1.length() - word2.length());
        }

        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; 
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i; // use add for every char c in word 2 
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                // replace
                else {
                    int replaceDistance = dp[i-1][j-1];
                    int addDistance = dp[i][j-1];
                    int deleteDistance = dp[i-1][j];
                    dp[i][j] = 1 + Math.min(Math.min(replaceDistance, addDistance), deleteDistance);
                }
            }
        }
        return dp[m][n];
    }
}
