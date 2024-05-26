class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int n=nums.length,q=queries.length;
        int res[]=new int[q];

        List<Integer> l=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if (nums[i]==x) l.add(i);
        }
        for(int i=0;i<q;i++)
        {
            if (queries[i]>l.size()) res[i]=-1;
            else res[i]=l.get(queries[i]-1);
        }
        return res;

    }
}