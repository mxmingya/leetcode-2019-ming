/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return help(preorder, inorder, 0, 0, inorder.length-1);
    }
    
    private TreeNode help(int[] preorder, int[] inorder, int preIndex, int inStart, int inEnd) {
        if (preIndex >= preorder.length || inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preIndex]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                // System.out.printf("%d %d\n", inorder[i], i);
                index = i;
            }
        }
        root.left = help(preorder, inorder, preIndex+1, inStart, index-1);
        root.right = help(preorder, inorder, preIndex+1+index-inStart, index+1, inEnd);
        return root;
    }
}
