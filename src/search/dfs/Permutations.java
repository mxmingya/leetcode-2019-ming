class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(nums, res, new LinkedList<Integer>());
        return res;
    }

    void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur) {
        if (cur.size() == nums.length) {
            res.add(new LinkedList<Integer>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(nums[i])) {
                continue;
            }
            cur.add(nums[i]);
            dfs(nums, res, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
