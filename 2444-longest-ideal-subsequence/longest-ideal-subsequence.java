class Solution {
    Integer[][] memo;
    public int longestIdealString(String s, int k) {
        memo=new Integer[s.length()][130];
        return longestIdealString(s,k,0,'#');
    }
    public int longestIdealString(String s, int k, int si, char prevChar){
        if(si>=s.length()) return 0;     
        if(memo[si][prevChar]!=null){
            return memo[si][prevChar];
        }
        int take=0;
        if(Math.abs(prevChar-s.charAt(si))<=k || prevChar=='#'){
            take = 1 + longestIdealString(s,k,si+1,s.charAt(si));
        }
        int notTake = longestIdealString(s,k,si+1,prevChar);
        return memo[si][prevChar] = Math.max(take,notTake);
    }
}