class Solution {
    public void dfs(int src,List<List<Integer>> adj,boolean[] vis)
    {
        vis[src]=true;

        for(int u:adj.get(src))
        {
            if (!vis[u])  dfs(u,adj,vis);
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj=new ArrayList<>();
        boolean vis[]=new boolean[n];

        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int[] e:edges)
        {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        dfs(source,adj,vis);
        
        return vis[destination];
    }
}