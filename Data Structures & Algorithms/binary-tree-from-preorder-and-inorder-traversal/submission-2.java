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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        int m = inorder.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, n-1, 0, m-1, map);
    }

    TreeNode build (int[] preorder, int[] inorder, int left1, int right1, int left2, int right2, HashMap<Integer, Integer> map) {
        if (left1 > right1 || left2 > right2) return null;

        TreeNode root = new TreeNode(preorder[left1]);
        int index = map.get(preorder[left1]);
        int leftSize = index - left2;
        root.left = build(preorder, inorder, left1+1, left1+leftSize, left2, index-1, map);
        root.right = build(preorder, inorder, left1+leftSize+1, right1, index+1, right2, map);

        return root;
    }
}
