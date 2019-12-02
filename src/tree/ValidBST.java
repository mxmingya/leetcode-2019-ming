/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ValidBST {
    Stack<TreeNode> s = new Stack<>();
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // stack: 
        // root: 5, 1, null, 1, null, 5, 4, 3, null, 3, null, 4, 6, null, 6, null
        // pre: null, 1, 5, 3, 4, 6
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            
            if (pre != null && root.val <= pre.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
}
