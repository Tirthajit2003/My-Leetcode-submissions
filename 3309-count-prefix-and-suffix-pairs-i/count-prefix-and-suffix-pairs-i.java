class Solution {
    public boolean isPreAndSuf(String str1,String str2)
    {
        return (str2.startsWith(str1) && str2.endsWith(str1));
    }
    public int countPrefixSuffixPairs(String[] words) {
       int n=words.length;
       int res=0;
       for(int i=0;i<n;i++)
       {
            for(int j=i+1;j<n;j++)
            {
                if (isPreAndSuf(words[i],words[j]))
                    res++;
            }
       } 
       return res;
    }
}