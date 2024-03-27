class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        int c=0,i=0;
        int prod=1;

        for(int j=0;j<n;j++)
        {
            prod*=nums[j];

            while(i<=j && prod>=k)
                prod/=nums[i++];

            c+=(j-i+1);
        }
        return c;
    }
}