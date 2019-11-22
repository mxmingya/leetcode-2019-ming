/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        
        TreeNode nRoot = null;
        
        if (t1 != null && t2 != null) {
            nRoot = new TreeNode(t1.val + t2.val);
        }
        if (t1 == null && t2 != null) {
            nRoot = new TreeNode(t2.val);
        }
        if (t1 != null && t2 == null) {
            nRoot = new TreeNode(t1.val);
        }
        
        TreeNode left = mergeTrees(t1 != null ? t1.left : t1, t2 != null ? t2.left : null);
        TreeNode right = mergeTrees(t1 != null ? t1.right : t1, t2 != null ? t2.right : null);
        
        nRoot.left = left;
        nRoot.right = right;
        
        return nRoot;
    }
}
