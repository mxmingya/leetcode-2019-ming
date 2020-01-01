/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LevelOrderTraversalDFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> levels = new HashMap<>();
        dfs(root, 0, levels);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < levels.keySet().size(); i++) {
            list.add(levels.get(i));
        }
        return list;
    }
    
    void dfs(TreeNode root, int level, Map<Integer, List<Integer>> levels) {
        if (root == null) {
            return;
        }
        if (!levels.containsKey(level)) {
            levels.put(level, new ArrayList<>());
        }
        // 0 -> 3
        // 1 -> 9, 20
        // 2 -> 15, 7
        levels.get(level).add(root.val);
        dfs(root.left, level+1, levels);
        dfs(root.right, level+1, levels);
    }
}
