class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m=rowSum.length,n=colSum.length;
        int res[][]=new int[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if (rowSum[i]<=colSum[j])
                {
                    res[i][j]=rowSum[i];
                    colSum[j]-=rowSum[i];
                    rowSum[i]=0;

                }
                else
                {
                    res[i][j]=colSum[j];
                    rowSum[i]-=colSum[j];
                    colSum[j]=0;
                }
            }
        }
        return res;

    }
}