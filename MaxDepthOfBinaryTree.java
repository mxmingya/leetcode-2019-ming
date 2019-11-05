class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int currentHeight = Math.max(leftDepth, rightDepth) + 1;
        return currentHeight;
    }
}
