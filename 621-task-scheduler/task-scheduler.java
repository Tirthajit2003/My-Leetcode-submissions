class Solution {
	public int leastInterval(char[] tasks, int n) {
		int m = tasks.length;
		int[] cnt = new int[26];
		
		for (char c: tasks) {
			cnt[c - 'A']++;
		}
		Arrays.sort(cnt);
		
        int max = cnt[25]-1;
		int spaces = max * n;
		
	
		for (int i = 24; i >= 0; i--) {
			spaces -= Math.min(max, cnt[i]);
		}

		spaces = Math.max(0, spaces);
		return tasks.length + spaces;
	}
}