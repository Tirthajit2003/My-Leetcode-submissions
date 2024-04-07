class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length;
        int inmax=1,decmax=1;
        int res=0;

        int l[]=new int[n];
        int r[]=new int[n];
        Arrays.fill(l,1);
        Arrays.fill(r,1);

        for(int i=1;i<n;i++)
        {
            if (nums[i]>nums[i-1])
                l[i]+=l[i-1];
            inmax=Math.max(inmax,l[i]);
        }

        for(int i=n-2;i>=0;i--)
        {
            if (nums[i]>nums[i+1])
                r[i]+=r[i+1];
            decmax=Math.max(decmax,r[i]);
        }
        res=Math.max(inmax,decmax);
        return res;

    }
}