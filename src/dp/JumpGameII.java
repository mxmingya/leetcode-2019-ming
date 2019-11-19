class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int curJump = nums[i];
            // if (dp[i] == Integer.MAX_VALUE) {
            //     return false;
            // }
            for (int j = 1; j <= curJump && i+j < nums.length; j++) {
                dp[i+j] = dp[i+j] < dp[i] + 1 ? dp[i+j] : dp[i] + 1; 
                if (i + j == nums.length) {
                    return dp[i+j];
                }
            }
        }
        
        return dp[nums.length-1];
    }
}
