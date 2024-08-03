class Solution {
    public int findKthPositive(int[] nums, int k) {
        int n=nums.length;
        List<Integer> res=new ArrayList<>();
        HashSet<Integer> h=new HashSet<>();
        int i=0;
        while(i<n)
        {
            int j=nums[i]-1;

            if (nums[i]<=n && nums[i]!=nums[j])
            {
                int t=nums[i];
                nums[i]=nums[j];
                nums[j]=t;
            }
            else i++;
        }

        for(int j=0;j<n;j++)
        {
            if (nums[j]!=j+1)
            {
                res.add(j+1);
                h.add(nums[j]);
            }
        }
        int j=1;
        while(res.size()<k)
        {
            int num=j+n;

            if (!h.contains(num)) res.add(num);

            j++;
        }
        return res.get(k-1);
    }
}