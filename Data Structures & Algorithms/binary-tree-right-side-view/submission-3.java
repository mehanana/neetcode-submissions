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
    public List<Integer> rightSideView(TreeNode root) {
        /*
        - bst
        - queue of nodes
        - while queue is not empty
            - store current size of queue
            - for index i = 0; i < size-1; i++
                - poll
                - add children (if any) to the queue
            - after the for loop, we'll store queue.poll() in list<integer> res
        */

        if (root == null) {
            return new ArrayList();
        }

        Queue<TreeNode> nodes = new ArrayDeque();
        nodes.offer(root);
        List<Integer> res = new ArrayList();

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = nodes.poll();
                if (i == size-1) {
                    res.add(curNode.val);
                }
                if (curNode.left != null) {
                    nodes.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodes.offer(curNode.right);
                }
            }
        }

        return res;
        
    }
}
