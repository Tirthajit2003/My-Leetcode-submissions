class Solution {
    public int jos(int n,int k)
    {
        if (n==1) return 0;
        
        return (jos(n-1,k)+k)%n;
    }
    public int findTheWinner(int n, int k) {
        return jos(n,k)+1;
    }
}