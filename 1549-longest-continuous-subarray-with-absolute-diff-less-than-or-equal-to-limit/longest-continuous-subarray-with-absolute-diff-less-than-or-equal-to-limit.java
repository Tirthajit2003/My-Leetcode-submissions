import java.util.TreeMap;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> maxMap = new TreeMap<>();
        //TreeMap<Integer, Integer> minMap = new TreeMap<>();
        int s = 0, res = 0;

        for (int i = 0; i < nums.length; i++) {
            maxMap.put(nums[i], maxMap.getOrDefault(nums[i], 0) + 1);
            //minMap.put(nums[i], minMap.getOrDefault(nums[i], 0) + 1);

            while (maxMap.lastKey() - maxMap.firstKey() > limit) {
                maxMap.put(nums[s], maxMap.get(nums[s]) - 1);
                if (maxMap.get(nums[s]) == 0) {
                    maxMap.remove(nums[s]);
                }

                // minMap.put(nums[s], minMap.get(nums[s]) - 1);
                // if (minMap.get(nums[s]) == 0) {
                //     minMap.remove(nums[s]);
                // }

                s++;
            }

            res = Math.max(res, i - s + 1);
        }

        return res;
    }
}
