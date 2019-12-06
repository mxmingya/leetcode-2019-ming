/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }        
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            } 
            else if (root.left == null) {
                root = root.right;
                return root;
            } 
            else if (root.right == null ) {
                root = root.left;
                return root;
            } 
            else {
                // left and right are both null
                TreeNode nextMin = findMin(root.right);
                root.val = nextMin.val;
                root.right = deleteNode(root.right, nextMin.val);
            }
        }
        return root;
    }
    
    private TreeNode findMin(TreeNode root) {
        if (root == null) {
            return root;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
