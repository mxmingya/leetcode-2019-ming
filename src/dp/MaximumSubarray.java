class MaximumSubarray {
    public int maxSubArray(int[] nums) {
       // write your code here
         int[] presum = new int[nums.length];
        presum[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // for i in arr nums, 
             // if all the previous sum greater than 0, add nums[i] to pre sum, 
             // else update presum as nums[i]
             if (presum[i-1] <= 0) {
                 presum[i] += nums[i];
                 res = res > nums[i] ? res : nums[i];
             } else {
                 presum[i] = presum[i-1] + nums[i];
                 res = res > presum[i] ? res : presum[i];
             }
        }
        return res;
    }
}
