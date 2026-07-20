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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        preOrder(root, sb);
        return sb.toString();
    }

    public void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N,");
            return;
        }
        sb.append(root.val);
        sb.append(',');
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] val = data.split(",");

        int[] i = {0};
        return buildTree(val, i);
    }

    public TreeNode buildTree(String[] val, int[] i) {
        if (val[i[0]].equals("N")) {
            i[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val[i[0]]));
        i[0]++;
        node.left = buildTree(val, i);
        node.right = buildTree(val, i);
        return node;
    }
}
