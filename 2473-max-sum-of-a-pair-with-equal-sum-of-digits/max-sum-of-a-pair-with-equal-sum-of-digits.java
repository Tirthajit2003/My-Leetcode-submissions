class Solution {
    public int sod(int num)
    {
        int sum=0;
        while(num>0)
        {
            sum+=(num%10);
            num/=10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> h=new HashMap<>();
        int res=-1;

        for(int i=0;i<n;i++)
        {
            int sum=sod(nums[i]);

            if (h.containsKey(sum))
            {
                res=Math.max(res,nums[i]+h.get(sum));
                h.put(sum,Math.max(h.get(sum),nums[i]));
            }
            else h.put(sum,nums[i]);
        }
        return res;
    }
}