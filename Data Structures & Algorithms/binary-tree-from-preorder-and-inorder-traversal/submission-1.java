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
    int preIdx = 0;
    int inIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*
        - preorder = root.val, root.left, root.right
        - in order = root.left, root.val, root.right

        val = preorder[0]
        find val in inorder, everything to the left of it is in the left root, everything to the right is in the right root
        - repeat building this with preorder[1] & left values array + preorder[2] & right values array
        */
        return buildTree(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int limit) {
        if (preIdx >= preorder.length) {
            return null;
        }
        if (inorder[inIdx] == limit) {
            inIdx++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIdx]);
        preIdx++;
        root.left = buildTree(preorder, inorder, root.val);
        root.right = buildTree(preorder, inorder, limit);
        return root;
    }
}
