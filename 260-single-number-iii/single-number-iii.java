class Solution {
    public int[] singleNumber(int[] nums) {
        int res[]=new int[2];
        int n=nums.length;
        int x=0;
        for(int i=0;i<n;i++)
            x=x^nums[i];

        int sn=x&(~(x-1));
        for(int i=0;i<n;i++)
        {
            if ((nums[i]&sn)!=0)res[0]=res[0]^nums[i];
            else res[1]=res[1]^nums[i];
        }
        return res;
        
    }
}