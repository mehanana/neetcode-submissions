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
    public boolean isBalanced(TreeNode root) {
        /*
        A height-balanced binary tree is defined as a 
        binary tree in which the left and right subtrees 
        of every node differ in height by no more than 1.
        root.left == root.right || root.left + 1 == root.right || root.left - 1 == root.right
        */

        if (root == null) {
            return true;
        } else {
            int left = size(root.left);
            int right = size(root.right);
            if (isBalanced(root.left) && isBalanced(root.right) && (left == right || left == right-1 || left == right+1)) {
                return true;
            } else {
                return false;
            }
        }
        
        
    }

    private int size(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(size(root.left), size(root.right));
        }
    }
}
