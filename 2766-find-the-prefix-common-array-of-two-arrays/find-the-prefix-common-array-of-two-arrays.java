class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int res[]=new int[n];
        HashMap<Integer,Integer> h=new HashMap<>();

        for(int i=0;i<n;i++)
        {
            h.put(A[i],h.getOrDefault(A[i],0)+1);
            h.put(B[i],h.getOrDefault(B[i],0)+1);
            int c=0;
            for(int j:h.values())
            {
                if (j==2) c++;
            }
            res[i]=c;
        }
        return res;

    }
}