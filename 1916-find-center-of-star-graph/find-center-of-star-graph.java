class Solution {
    public int findCenter(int[][] edges) {
        HashSet<Integer> h=new HashSet<>();
        int res=0;
        for(int i=0;i<edges.length;i++)
        {
            for(int j=0;j<2;j++)
            {
                if (h.contains(edges[i][j])) res=edges[i][j];
                else h.add(edges[i][j]);
            }
        }
        return res;
    }
}