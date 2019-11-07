class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(nums, res, new LinkedList<Integer>(), new HashMap<Integer, Boolean>());
        return res;
    }

    void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur, HashMap<Integer, Boolean> map) {
        if (cur.size() == nums.length) {
            res.add(new LinkedList<Integer>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            
            if (map.containsKey(nums[i]) && map.get(nums[i])) {
                continue;
            }
            cur.add(nums[i]);
            map.put(nums[i], true);
            dfs(nums, res, cur, map);
            cur.remove(cur.size() - 1);
            map.put(nums[i], false);
        }
    }
}
