class Solution {
    int dr[][]={{-1,0},{1,0},{0,1},{0,-1}};
    int maxx=0;
    int maxy=0;
    public void dfs(int i,int j,boolean[][] vis,int[][] land,List<Integer> l)
    {
        vis[i][j]=true;
        maxx=Math.max(maxx,i);
        maxy=Math.max(maxy,j);
        for(int[] d:dr)
        {
            if (i+d[0]>=0 && i+d[0]<land.length && j+d[1]>=0 && j+d[1]<land[0].length
            && vis[i+d[0]][j+d[1]]==false && land[i+d[0]][j+d[1]]==1)
            {
                dfs(i+d[0],j+d[1],vis,land,l);
            }
        }
    }
    public int[][] findFarmland(int[][] land) {
        List<List<Integer>> res=new ArrayList<>();
        int m=land.length;
        int n=land[0].length;
        boolean vis[][]=new boolean[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if (vis[i][j]==false && land[i][j]==1)
                {
                    List<Integer> l =new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    maxx=i;
                    maxy=j;
                    dfs(i,j,vis,land,l);
                    l.add(maxx);
                    l.add(maxy);
                    res.add(new ArrayList(l));
                }
            }
        }
        int len=res.size();
        int ans[][]=new int[len][4];

        for(int i=0;i<len;i++)
        {
            ans[i][0]=res.get(i).get(0);
            ans[i][1]=res.get(i).get(1);
            ans[i][2]=res.get(i).get(2);
            ans[i][3]=res.get(i).get(3);
        }
        return ans;


    }
}