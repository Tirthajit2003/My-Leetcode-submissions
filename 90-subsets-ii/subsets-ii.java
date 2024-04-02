class Solution {
    public void find(int i, int[] nums, List<Integer> l, List<List<Integer>> res) {
    if (i == nums.length) {
        List<Integer> sortedList = new ArrayList<>(l);
        Collections.sort(sortedList);
        if (!res.contains(sortedList)) {
            res.add(sortedList);
        }
        return;
    }
    l.add(nums[i]);
    find(i + 1, nums, l, res);
    l.remove(l.size() - 1);
    find(i + 1, nums, l, res);
}

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> l=new ArrayList<>();
        find(0,nums,l,res);
        return res;
    }
}