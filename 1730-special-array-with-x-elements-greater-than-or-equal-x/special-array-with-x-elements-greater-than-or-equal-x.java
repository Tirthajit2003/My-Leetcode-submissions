class Solution {
    public int specialArray(int[] nums) {
        int n=nums.length;
        int res=-1,maxi=Integer.MIN_VALUE;

        for(int i=0;i<n;i++)
            maxi=Math.max(maxi,nums[i]);

        int freq[]=new int[maxi+1];

        for(int num:nums)
            freq[num]++;

        // int arr[]=new int[maxi+1];
        // arr[maxi]=freq[maxi];
        int t=freq[maxi];
        if (t==maxi) return maxi;
        for(int i=maxi-1;i>=0;i--)
        {
            t=t+freq[i];
            if (t==i) return i;
        }
        return -1;
    }
}