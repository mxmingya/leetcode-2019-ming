class DecodeWays {
    public int numDecodings(String s) {
        int res = 0, len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for (int i = 2; i < len+1; i++) {
            int first = Integer.parseInt(s.substring(i-1, i));
            int second = Integer.parseInt(s.substring(i-2, i));
            if (first != 0) {
                dp[i] += dp[i-1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[len];
    }   
}
