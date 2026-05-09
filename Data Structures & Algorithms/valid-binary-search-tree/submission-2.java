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
        if root null --> return true
        look at root.left & look at root.right
            - if root > root.left && root < root.right --> keep traversing through list
            - else return false
        */

        /*
        if (root == null) {
            return true;
        } else if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null) {
            if (root.val < root.right.val) {
                return isValidBST(root.right);
            } else {
                return false;
            }

        } else if (root.right == null) {
            if (root.val > root.left.val) {
                return isValidBST(root.left);
            } else {
                return false;
            }
        } else {
            if (root.val > root.left.val && root.val < root.right.val) {
                return isValidBST(root.left) && isValidBST(root.right);
            } else {
                return false;
            }
        }
        */
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validate(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        } else {
            return root.val > min && root.val < max
                    && validate(root.left, min, root.val)
                    && validate(root.right, root.val, max);
        }
    }
}
