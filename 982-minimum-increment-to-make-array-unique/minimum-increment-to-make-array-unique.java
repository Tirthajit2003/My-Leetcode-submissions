class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n=nums.length;
        HashSet<Integer> h=new HashSet<>();
        int maxi=0,res=0;
        Arrays.sort(nums);

        for(int i=0;i<n;i++)
        {
            int c=nums[i];

            if (!h.contains(c)) h.add(c);
            else
            {
                res+=(maxi+1-nums[i]);
                nums[i]=maxi+1;
                h.add(nums[i]);
            }
            maxi=Math.max(maxi,nums[i]);
            
        }
        return res;
    }
}