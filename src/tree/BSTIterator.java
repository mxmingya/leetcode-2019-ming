/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack  = new Stack<TreeNode>();
        
        if (root != null) {
            stack.push(root);
            while (root.left != null) {
                stack.push(root.left);
                root = root.left;
            }
        }
        
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        if (cur.right != null) {
            stack.push(cur.right);
            TreeNode left = stack.peek().left;
            while (left != null) {
                stack.push(left);
                left = left.left;
            }
        }
        return cur.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
