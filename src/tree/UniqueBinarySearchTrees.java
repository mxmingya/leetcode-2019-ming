class  UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        if (n < 2) {
            return dp[n];
        }
        for (int i = 2; i <= n; i++) {
            // dp[n] means number of ways of unique bst we can construct from n nodes.
            int curNum = 0;
            for (int j = 0; j < i/2; j++) {
                curNum += dp[j] * dp[i-j-1];
                curNum += dp[j] * dp[i-j-1];
            }
            if (i % 2 == 1) {
                curNum += dp[i/2] * dp[i/2];    
            }
            
            dp[i] = curNum;
        }
        return dp[n];
    }
}
