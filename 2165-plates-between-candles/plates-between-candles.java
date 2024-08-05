import java.util.*;

public class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        List<Integer> temp = new ArrayList<>();
        int n = s.length();
        
        // Collecting indices of candles ('|')
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                temp.add(i);
            }
        }
        
        int[] ans = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            
            // Finding lower bound for start
            int startInd = Collections.binarySearch(temp, start);
            if (startInd < 0) {
                startInd = -startInd - 1;  // Convert to insertion point
            }
            System.out.println(startInd);
            
            // Finding upper bound for end
            int endInd = Collections.binarySearch(temp, end);
            if (endInd < 0) {
                endInd = -endInd - 1;  // Convert to insertion point
            } else {
                endInd++;  // If exact match is found, move to next element
            }
            endInd--; 
            System.out.println(endInd); 
            
            if (endInd <= startInd) {
                ans[i] = 0;  // No candles between start and end
            } else {
                // Number of plates between candles
                int numberOfPlates = temp.get(endInd) - temp.get(startInd) - (endInd - startInd);
                ans[i] = numberOfPlates;
            }
        }
        
        return ans;
    }
}
