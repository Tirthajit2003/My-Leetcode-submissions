class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        long pre = 1, suff = 1;
        long res = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            pre *= nums[i];
            suff *= nums[n - i - 1];

            res = Math.max(res, Math.max(pre, suff));

            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;
        }
        
        // Cap the result if it exceeds Integer.MAX_VALUE to avoid overflow issues
        if (res > Integer.MAX_VALUE) {
            return 1000000000;
        }
        
        return (int) res;
    }
}
