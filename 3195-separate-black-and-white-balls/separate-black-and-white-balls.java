class Solution {
    public long minimumSteps(String s) {
        int n=s.length();
        int a[]=new int[n];

        for(int i=0;i<n;i++)
            a[i]=s.charAt(i)-'0';

        long c0=0,ans=0;

        for(int i=n-1;i>=0;i--)
        {
            if (a[i]==0) c0++;
            else ans+=c0;
        }
        return ans;



    }
}