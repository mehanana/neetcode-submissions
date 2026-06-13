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
    int best = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        /*
        - let's say it's small tree
            -15
        10       20
        - cur is -15
        - go to left
            - add val to cur (10+-15), since this increases the value, save it
            - but also look at 10's children with 10 as curSum & pick the max
            - 10 has no children so go back up to -15 & curmax = -5
            - now look at right, and it's 20, so cursum is 15
            - 20 has no children, but the max here is 20 (20 vs 15), so we return 20
        */

        gain(root);
        return best;
    }

    private int gain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, gain(node.left));
        int right = Math.max(0, gain(node.right));
        best = Math.max(best, node.val + left + right);
        return node.val + Math.max(left, right);
    }
}
