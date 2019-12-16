/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, postorder.length-1, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] in, int[] post, int postIndex, int inStart, int inEnd) {
        if (postIndex < 0 || inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(post[postIndex]);
        int index = -1;
        for (int i = in.length-1; i >= 0; i--) {
            if (in[i] == root.val) {
                index = i;
                break;
            }
        }
        root.right = helper(in, post, postIndex-1, index+1, inEnd);
        root.left = helper(in, post, postIndex-1-(inEnd-index), inStart, index-1);
        return root;
    }
}
