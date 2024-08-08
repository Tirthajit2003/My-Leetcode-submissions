class Solution {
    public int bfs(List<List<Integer>> adj,int n,int s)
    {
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<Integer> q=new LinkedList<>();
        dist[s]=0;
        q.add(s);
        boolean vis[]=new boolean[n];

        while(!q.isEmpty())
        {
            int u=q.poll();
            vis[u]=true;
            for(int v:adj.get(u))
            {
                if (!vis[v])
                {
                    dist[v]=Math.min(dist[v],dist[u]+1);
                    q.offer(v);
                }
                
            }

        }
        return dist[n-1];

    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int q=queries.length;
        int res[]=new int[q];

        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<n-1;i++)
            adj.get(i).add(i+1);

        for(int i=0;i<q;i++)
        {
            adj.get(queries[i][0]).add(queries[i][1]);
            res[i]=bfs(adj,n,0);
        }
        return res;
    }
}