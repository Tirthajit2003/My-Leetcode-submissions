class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        int res=0,psum=0;
        HashMap<Integer,Integer> h=new HashMap<>();

        for(int i=0;i<n;i++)
        {
            if (nums[i]==0) nums[i]=-1;
        }

        for(int i=0;i<n;i++)
        {
            psum+=nums[i];
            if (psum==0) res=i+1;
            if (h.containsKey(psum))
                res=Math.max(res,i-h.get(psum));
            else h.put(psum,i);
        }
        return res;
    }
}