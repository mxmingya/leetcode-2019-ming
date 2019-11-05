class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null) {
            return 0;
        }
        return dfs(coins, amount);
    }
    
    int dfs(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int minAtCurNode = Integer.MAX_VALUE;  // initiate a value to represent the current min number of nodes. 
        for (int i = 0; i < coins.length; i++) {
            int curCoin = coins[i];
            int res = dfs(coins, amount-curCoin);
            if (res >= 0 && minAtCurNode > res) {
                minAtCurNode = res + 1;
            }
        }
        
        if (minAtCurNode == Integer.MAX_VALUE) {
                return -1;
            } 
        else {
                return minAtCurNode;
        }
        
    }
}
