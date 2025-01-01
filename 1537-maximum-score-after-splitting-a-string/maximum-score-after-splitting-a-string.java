class Solution {
    public int maxScore(String s) {
        int n=s.length(),res=0;
        int oc[]=new int[n];
        
        for(int i=n-2;i>=0;i--)
        {
            if (s.charAt(i+1)=='1') oc[i]=oc[i+1]+1;
            else oc[i]=oc[i+1];
        }

        int zc=0;

        for(int i=0;i<n;i++)
        {
            if (s.charAt(i)=='0') zc++;
            if (i!=n-1) res=Math.max(res,zc+oc[i]);
        }
        return res;

        


    }
}