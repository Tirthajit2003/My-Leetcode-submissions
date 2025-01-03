class Solution {
    public int waysToSplitArray(int[] nums) {
        int n=nums.length;
        long tsum=0;
        for(int i=0;i<n;i++)
            tsum+=nums[i];

        long lsum=0;
        int res=0;
        for(int i=0;i<n-1;i++)
        {
            lsum+=nums[i];
            tsum-=nums[i];
            if (lsum>=tsum) res++;
        }
        return res;
    }
}