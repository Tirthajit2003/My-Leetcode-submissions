class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] cnt1 = new int[1001];
        
        for (int v : target) {
            ++cnt1[v];
        }
        for (int v : arr) {
            --cnt1[v];
        }
        for(int i=0;i<1001;i++)
            if (cnt1[i]!=0) return false;

        return true;
    }
}