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

public class Codec {
    List<String> res = new ArrayList<>();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        /*
        how to know left or right
        could do inorder & preorder

        - use preorder --> cur, left, right
        1, 2, n, n, 3, 4, n, n, 5, n, n
          1
        2   3
           4 5

        */
        dfs(root);
        return String.join(",", res);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            res.add("N");
            return;
        } else {
            res.add(String.valueOf(root.val));
            dfs(root.left);
            dfs(root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] i = {0};
        return dfsD(vals, i);
    }

    private TreeNode dfsD(String[] vals, int[] i) {
        if (vals[i[0]].equals("N")) {
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        node.left = dfsD(vals, i);
        node.right = dfsD(vals, i);
        return node;
    }
}
