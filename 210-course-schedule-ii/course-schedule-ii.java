class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        List<List<Integer>> adj=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        List<Integer> res=new ArrayList<>();
        int in[]=new int[n];

        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int[] p:prerequisites)
        {
            adj.get(p[1]).add(p[0]);
            in[p[0]]++;
        }
        for(int i=0;i<n;i++)
        {
            if (in[i]==0) q.offer(i);
        }
        while(!q.isEmpty())
        {
            int u=q.poll();
            res.add(u);
            for(int v:adj.get(u))
            {
                in[v]--;
                if (in[v]==0) q.offer(v);
            }
        }
        for(int i=0;i<n;i++)
        {
            if (in[i]!=0) return new int[0];
        }
        int l=res.size();
        int ans[]=new int[l];

        for(int i=0;i<l;i++)
            ans[i]=res.get(i);

        return ans;


            


    }
}