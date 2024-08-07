import java.util.*;

class Solution {
    public int findStart(int[][] rides, int start, int target) {
        int low = start, high = rides.length - 1;
        int res = rides.length; // Changed from 0 to rides.length to handle cases where no valid start is found

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (rides[mid][0] >= target) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public long find(int i, int[][] rides, Map<Integer, Long> dp) {
        if (i >= rides.length) return 0;
        if (dp.containsKey(i)) return dp.get(i);

        int idx = findStart(rides, i + 1, rides[i][1]);
        long pick = rides[i][1] - rides[i][0] + rides[i][2] + find(idx, rides, dp);
        long npick = find(i + 1, rides, dp);

        long result = Math.max(pick, npick);
        dp.put(i, result);

        return result;
    }

    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, Comparator.comparingInt(o -> o[0]));
        Map<Integer, Long> dp = new HashMap<>();

        return find(0, rides, dp);
    }
}
