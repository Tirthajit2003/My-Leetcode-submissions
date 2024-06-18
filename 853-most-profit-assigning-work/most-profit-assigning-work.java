import java.util.*;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int m = difficulty.length;
        int n = worker.length;
        
        // Create a list of pairs (difficulty, profit) sorted by difficulty
        List<Pair<Integer, Integer>> jobs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            jobs.add(new Pair<>(difficulty[i], profit[i]));
        }
        Collections.sort(jobs, Comparator.comparing(Pair::getKey));
        
        // Sort workers by their ability
        Arrays.sort(worker);
        
        int maxProfit = 0;
        int currMaxProfit = 0;
        int j = 0;
        
        // Iterate over workers and find the maximum profit for each worker
        for (int ability : worker) {
            // Update max profit if current job's difficulty is less than worker's ability
            while (j < m && jobs.get(j).getKey() <= ability) {
                currMaxProfit = Math.max(currMaxProfit, jobs.get(j).getValue());
                j++;
            }
            maxProfit += currMaxProfit;
        }
        
        return maxProfit;
    }
}
