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
    public boolean isValidBST(TreeNode root) {
        /*
             2
           1   3
          0 5

          - helper method that takes in lower bound & upper bound & root 
          --> return false if root.val is NOT between these bounds
          --> return helper(root.left, lowerbound, upperbound) && helper(root.right,lowerBound, upperBound)
        */

        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }

    private boolean helper(TreeNode root, int low, int high) {
        if (root == null) {
            return true;
        }
        if (root.val <= low || root.val >= high) {
            return false;
        }
        return helper(root.left, low, root.val) && helper(root.right, root.val, high);
    }
}
