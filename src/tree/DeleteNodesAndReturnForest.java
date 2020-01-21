/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class DeleteNodesAndReturnForest {
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root  == null) {
            return null;
        }
        Set<Integer> toDelete = new HashSet<>();
        for (int i : to_delete) {
            toDelete.add(i);
        }
        helper(root, toDelete, true);
        return res;
    }
    
    private TreeNode helper(TreeNode root, Set<Integer> toDelete, boolean isRoot) {
        if (root == null) {
            return root;
        }
        boolean toBeDelete = toDelete.contains(root.val);
        
        if (isRoot && !toBeDelete) {
            // System.out.println(root.val);
            res.add(root);
        }
        // if this parent of node is deleted, then it is the root of subtree that will be added to the results set
        root.left = helper(root.left, toDelete, toBeDelete);
        root.right = helper(root.right, toDelete, toBeDelete);
        return toBeDelete ? null : root;
    }
}
