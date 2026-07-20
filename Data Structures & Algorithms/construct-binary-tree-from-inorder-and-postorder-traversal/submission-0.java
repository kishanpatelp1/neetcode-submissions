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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        int m = postorder.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return construct(inorder, postorder, 0, n-1, 0, m-1, map);
    }

    public TreeNode construct(int[] inorder, int[] postorder, int left1, int right1, int left2, int right2, HashMap<Integer, Integer> map) {
        if (left1 > right1 || left2 > right2) return null;

        TreeNode root = new TreeNode(postorder[right2]);
        int index = map.get(postorder[right2]);
        int leftSize = index - left1;

        root.left = construct(inorder, postorder, left1, index-1, left2, left2+leftSize-1, map);
        root.right = construct(inorder, postorder, index+1, right1, left2+leftSize, right2-1, map);

        return root;
    }
}