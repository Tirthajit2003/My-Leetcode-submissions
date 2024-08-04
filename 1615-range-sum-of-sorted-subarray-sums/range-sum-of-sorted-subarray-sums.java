class Solution {
    int mod=1000000007;
    public int rangeSum(int[] nums, int n, int left, int right) {
        int sums[]=new int[n*(n+1)/2];
        int idx=0;

        for(int i=0;i<n;i++)
        {
            int sum=nums[i];
            sums[idx++]=sum;
            for(int j=i+1;j<n;j++)
            {
                sum+=nums[j];
                sums[idx++]=sum;
            }
        }
        Arrays.sort(sums);
        int res=0;

        for(int i=left-1;i<=(right-1);i++)
            res=(res+(sums[i]%mod))%mod;

        return res;

    }
}