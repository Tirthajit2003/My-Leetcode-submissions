class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n=nums.length;
        long tsum=0;
        int del[]=new int[n];

        for(int num:nums)
            tsum+=num;

        for(int i=0;i<n;i++)
        {
            del[i]=(nums[i]^k)-nums[i];
        }
        Arrays.sort(del);
        
        for(int i=n-1;i>=0;i-=2)
        {
            if (i==0) break;
            if (del[i]+del[i-1]>0) tsum+=(del[i]+del[i-1]);
        }
        return tsum;

    }
}