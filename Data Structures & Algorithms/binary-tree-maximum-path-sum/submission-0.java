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
    int curMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        /*
        smth like the diameter question (left, cur, right)
        1. can include root, left and right
        2. can include root and (left or right)
        3. can include root and its parent

        check root, left, and right --> store if ti's greater than max
        then run recursive this plus left root and this plus right root and pick max
        */
        gain(root);
        return curMax;
    }

    private int gain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftGain = Math.max(0, gain(root.left));
        int rightGain = Math.max(0, gain(root.right));
        curMax = Integer.max(curMax, root.val + leftGain + rightGain);

        return root.val + Math.max(leftGain, rightGain);
    }

}
