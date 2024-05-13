class Solution {
    public int findPermutationDifference(String s, String t) {
        int n=s.length(),res=0;

        for(int i=0;i<n;i++)
            res+=Math.abs(i-t.indexOf(s.charAt(i)));

        return res;
    }
}