/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        /*
        - bst traversal
        - queue of nodes
        - add root to queue
        - while queue is not empty
            - store the size of the queue currently
            - for index 0-size of queue
                - pop, add to list
                - add left & right children to the queue
            - add this list to res
        */
        if (root == null) {
            return new ArrayList();
        }

        Queue<TreeNode> nodes = new ArrayDeque();
        nodes.offer(root);
        List<List<Integer>> res = new ArrayList();

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> level = new ArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode cur = nodes.poll();
                level.add(cur.val);
                if (cur.left != null) {
                    nodes.offer(cur.left);
                }
                if (cur.right != null) {
                    nodes.offer(cur.right);
                }
            }
            res.add(level);
        }
        return res;


        
    }
}
