class JumpGameShort {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int canReach = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (canReach < i) {
                return false;
            }
            canReach = Math.max(canReach, nums[i]+i);
        }
        return canReach >= nums.length-1;
    }
}
