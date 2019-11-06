class CoinChangeDP2 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0; // i-i+1 = 1
        // how many coins are needed at [i][j] to sum up to dp[i][j] amount
        for (int i = 1; i < amount+1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);    
                }
            }
        }
        int last = dp[amount];
        return last == amount+1 ? -1 : last;
    }
}
