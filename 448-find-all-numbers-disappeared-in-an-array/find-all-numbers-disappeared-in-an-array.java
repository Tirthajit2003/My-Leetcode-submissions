class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> l=new ArrayList<>();
        int n=nums.length;
        int i=0;

        while(i<n)
        {
            if (nums[i]!=nums[nums[i]-1])
            {
                int t=nums[i];
                nums[i]=nums[nums[i]-1];
                nums[t-1]=t;
            }
            else i++;
        }

        for(int j=0;j<n;j++)
        {
            if (nums[j]!=j+1)
                l.add(j+1);
        }
        return l;

    }
}