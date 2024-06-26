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
    int res=0;
    public int find(TreeNode root)
    {
        if (root==null) return 0;

        int l=find(root.left);
        int r=find(root.right);

        res+=(Math.abs(l)+Math.abs(r));

        return l+r+root.val-1;
    }
    public int distributeCoins(TreeNode root) {
        find(root);
        return res;
    }
}