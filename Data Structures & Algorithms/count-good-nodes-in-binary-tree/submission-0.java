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
    public int goodNodes(TreeNode root) {
        /*
        dfs
        - as we go to next node, also send max node up until then
        - if cur val > max, replace max AND add 1
        - if cur val < max, add 0 and go to next level
        */
        if (root == null) {
            return 0;
        } else {
            return 1 + helper(root.left, root.val) + helper(root.right, root.val);
        }
        
    }

    private int helper(TreeNode root, int curMax) {
        if (root == null) {
            return 0;
        } else if (root.val >= curMax) {
            return 1 + helper(root.left, root.val) + helper(root.right, root.val);
        } else {
            return helper(root.left, curMax) + helper(root.right, curMax);
        }
    }
}
