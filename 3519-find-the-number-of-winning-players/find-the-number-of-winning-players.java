class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        int p=pick.length;
        int res=0;

        for(int i=0;i<n;i++)
        {
            int freq[]=new int[11];
            boolean f=false;
            for(int j=0;j<p;j++)
            {
                if (pick[j][0]==i)
                {
                    freq[pick[j][1]]++;
                    if(freq[pick[j][1]]>i)
                    {
                        f=true;
                        break;
                    }
                }
            }
            if (f) res++;
        }
        return res;
    }
}