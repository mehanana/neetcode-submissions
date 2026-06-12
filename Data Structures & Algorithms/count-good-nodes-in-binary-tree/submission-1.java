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
        - root is always a good node
        - then go to root.left & root.right

        - keep track of the max value seen so far


        - helper method that takes in root and max value --> returns the count of good nodes
        - if it's null, return 0
        - look at curValue, if it's greater than or equal to max value, do 1 + helper(root.left, curValue) + helper(root.right, curValue)
        - if it's less than max, do helper(root.left, max) + helper(root.right, max)
        */

        return count(root, Integer.MIN_VALUE);
    }

    private int count(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        if (root.val >= max) {
            return 1 + count(root.left, root.val) + count(root.right, root.val);
        } else {
            return count(root.left, max) + count(root.right, max);
        }
    }
}
