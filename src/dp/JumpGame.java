class JumpGame.java {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        
        for (int i = 0; i < dp.length; i++) {
            if (dp[i]) {
                for (int j = 1; j <= nums[i]; j++) {
                    if (i+j < nums.length) {
                        // System.out.printf("%d is true\n", i+j);
                        dp[i+j] = true;
                        if (i+j == nums.length-1) {
                            return true;
                        }
                    }
                }    
            } else {
                return false;
            }
            
        }
        return dp[nums.length-1];
    }
}
