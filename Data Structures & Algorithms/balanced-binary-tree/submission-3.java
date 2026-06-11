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
        return heightOrUnbalanced(root) > -1;
/*

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
        */
        
    }

    private int heightOrUnbalanced(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = heightOrUnbalanced(root.left);
        if (left == -1) {
            return -1;
        }
        int right = heightOrUnbalanced(root.right);
        if (right == -1) {
            return -1;
        }
        if (left == right || left + 1 == right || left - 1 == right) {
            return Math.max(left, right) + 1;
        } else {
            return -1;
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
