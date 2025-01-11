class Solution {
    public boolean canConstruct(String s, int k) {
       int n=s.length();
       if (n<k) return false;

       HashMap<Character,Integer> h=new HashMap<>();

        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            h.put(c,h.getOrDefault(c,0)+1);
        }
            
        int of=0;
        for (int i:h.values())
        {
            if (i%2!=0) of++;
        }
        if (of<=k) return true;

        return false;


    }
}