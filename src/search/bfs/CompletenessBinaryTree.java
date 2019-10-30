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
     
         public boolean isCompleteTreeDFS(TreeNode root) {
        if (root == null ) {
            return true;
        }
        return dfs(root, 0, countNodes(root));
    }
    
    boolean dfs(TreeNode root, int index, int numOfNodes) {
        if (root == null) {
            return true;
        }
        if (index >= numOfNodes) {
            return false;
        }
        return dfs(root.left, index*2+1, numOfNodes) && dfs(root.right, index*2+2, numOfNodes);
    }
    
    int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    }
