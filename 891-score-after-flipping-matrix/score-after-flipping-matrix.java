class Solution {
    public int matrixScore(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        for(int i=0;i<m;i++)
        {
            if (grid[i][0]==0)
            {
                for(int j=0;j<n;j++)
                    grid[i][j]=1-grid[i][j];
            }
        }
        for(int j=0;j<n;j++)
        {
            int c0=0;
            int c1=0;
            for(int i=0;i<m;i++)
            {
                if (grid[i][j]==0) c0++;
                else c1++;
            }
            if (c0>=c1)
            {
                for(int i=0;i<m;i++)
                {
                    grid[i][j]=1-grid[i][j];
                }
            }
        }
        int res=0;
        for(int i=0;i<m;i++)
        {
            int temp=0,pos=0;
            for(int j=n-1;j>=0;j--)
            {
                temp+=(((int)Math.pow(2,pos))*grid[i][j]);
                pos++;
            }
            res+=temp;
            
        }
        return res;

    }
}