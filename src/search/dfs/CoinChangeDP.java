class CoinChangeDP {
    public int coinChange(int[] coins, int amount) {
        if (coins == null) {
            return 0;
        }
        
        return dfs(coins, amount, new int[amount+1]);
    }
    
    int dfs(int[] coins, int amount, int[] dp) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != 0) {
            return dp[amount];
        }       
        int minAtCurNode = Integer.MAX_VALUE;  // initiate a value to represent the current min number of nodes. 
        for (int i = 0; i < coins.length; i++) {
            int curCoin = coins[i];
            int res = dfs(coins, amount-curCoin, dp);
            if (res >= 0 && minAtCurNode > res) {
                minAtCurNode = res + 1;
            }
        }
        dp[amount] = minAtCurNode == Integer.MAX_VALUE ? -1 : minAtCurNode;
        return dp[amount];
        
    }
}
