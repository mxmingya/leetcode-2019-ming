class LowestCommonAncestorofDeepestLeaves {
    TreeNode lca;
    int maxDepth;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root, 0);
        return lca;
    }
    
    private int helper(TreeNode root, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        if (root == null) {
            return depth;
        }
        int left = helper(root.left, depth+1);
        int right = helper(root.right, depth+1);
        // since the maxDepth is passed along the tree nodes, every node in a subtree with leaves has  the same maxDepth returned. 
        // we update the lca all the way back to the root from post search
        if (left == maxDepth && right == maxDepth) {
            lca = root;
        }
        return Math.max(left, right);
    }
}
