class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        HashMap<Character,Integer> h=new HashMap<>();
        int p=0,res=0;

        for(int i=0;i<n;i++)
        {
            h.put(s.charAt(i),h.getOrDefault(s.charAt(i),0)+1);
            if (h.get(s.charAt(i))>2)
            {
                res=Math.max(res,i-p);
                while(h.get(s.charAt(i))>2)
                {
                    h.put(s.charAt(p),h.get(s.charAt(p))-1);
                    p++;
                }
            }
        }
        res=Math.max(res,n-p);
        return res;
    }
}