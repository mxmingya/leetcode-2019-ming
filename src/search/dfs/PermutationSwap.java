class PermutationSwap {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(nums, res, 0);
        return res;
    }
    
    void dfs(int[] nums, List<List<Integer>> res, int index) {
        if (index == nums.length) {
            List<Integer> list = new LinkedList<Integer>();
            for (int i : nums) {
                list.add(i);
            }
            res.add(list);
        }
        
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            dfs(nums, res, index+1);
            swap(nums, index, i);
        }
    }
    
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
