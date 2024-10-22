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
    public void bfs(TreeNode root,List<Long> hsum)
    {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int s=q.size();
            long csum=0;
            for(int i=0;i<s;i++)
            {
                TreeNode t=q.poll();
                csum+=t.val;
                if (t.left!=null) q.offer(t.left);
                if (t.right!=null) q.offer(t.right);
            }
            hsum.add(csum);
        }

    }
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> hsum=new ArrayList<>();
        bfs(root,hsum);
        Collections.sort(hsum);
        int l=hsum.size();

        if (l<k) return -1;

        return hsum.get(l-k);
    }
}