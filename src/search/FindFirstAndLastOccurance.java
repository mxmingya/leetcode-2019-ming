class FindFirstAndLastOccurance {
    public int[] searchRange(int[] nums, int target) {
        
        int first = -1, second = -1;
        int[] res = {first, second};
        if (nums.length == 0) {
            return res;
        }
        first = bs(nums, target, true);
        second = bs(nums, target, false);
        res[0] = first; res[1] = second;
        return res;
    }
    
    int bs(int[] nums, int target,  boolean findFirst) {
        int res = -1;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                if (findFirst) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                res = mid;
            }
            else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
}
