class Solution {
    List<List<Integer>> res=new ArrayList<>();

    public void subsets(int i,int[] nums,List<Integer> l)
    {
        if (i==nums.length)
        {
            res.add(new ArrayList<>(l));
            return;
        }

        l.add(nums[i]);
        subsets(i+1,nums,l);
        l.remove(l.size()-1);
        subsets(i+1,nums,l);
    }


    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        subsets(0,nums,new ArrayList<>());
        return res;

    }
}