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
        list<list>
        add root to the inner list
        add new list
        add root.left and root.right to that new list
        traverse through that next list
        add root.left.left & root.left.right && root.right.left && root.right.right to a new list
        go to that list ...
        */

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for (int i = q.size(); i > 0; i--) { // since we're adding the children to q, we don't want the starting size to change. like for this loop, we want to go through all children at this level, and as we're adding, the size changes. that's why we use the starting size and decrement instead of incrementing like usual
                TreeNode node = q.poll();
                if (node != null) {
                    level.add(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            if (level.size() > 0) {
                result.add(level);
            }
        }


        return result;
    }
}
