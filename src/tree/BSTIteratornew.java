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
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s = new Stack<TreeNode>();
        
        while (root != null) {
            s.push(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        if (hasNext()) {
             TreeNode next = s.pop();
            TreeNode right = next.right;
            while (right != null) {
                s.push(right);
                right = right.left;
            }
            return next.val;
        }
        return -1;
       
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
