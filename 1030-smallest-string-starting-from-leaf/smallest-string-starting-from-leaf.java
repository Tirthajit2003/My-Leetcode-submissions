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
    String ans="";
    public void find(TreeNode root,StringBuilder sb)
    {
        if (root==null) return;

        if (root.left==null && root.right==null)
        {
            sb.insert(0,(char)(root.val+97));
            String news=sb.toString();
            if (ans.length()==0 | ans.compareTo(news)>0)
                ans=news;
            sb.deleteCharAt(0);
            return;
        }

        sb.insert(0,(char)(root.val+97));
        find(root.left,sb);
        find(root.right,sb);
        sb.deleteCharAt(0);
    }
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        find(root,sb);
        return ans;
    }
}