package search.bfs;

import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
    class CompletenessBinaryTree {
        public boolean isCompleteTree(TreeNode root) {
            if (root == null) {
                return true;
            }
            
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (q.peek() != null) {
                TreeNode cur = q.poll();
                // offer null to queue too.
                q.offer(cur.left);
                q.offer(cur.right);
            }

            while (!q.isEmpty() && q.peek() == null) {
                q.poll();
            }
            return q.isEmpty();
        }
    }