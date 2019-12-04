/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class KthSmallestBST {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;
        
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                // push left
                s.push(root);
                root = root.left;
            }
            root = s.pop(); // get the next smallest
            k--;
            if (k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return Integer.MAX_VALUE;
    }
}
