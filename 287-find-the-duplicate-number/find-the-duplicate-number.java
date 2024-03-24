class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> h=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if (h.contains(nums[i])) return nums[i];
            else h.add(nums[i]);
        }
        return -1;
    }
}