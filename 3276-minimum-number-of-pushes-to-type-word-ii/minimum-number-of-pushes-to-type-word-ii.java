class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int freq[]=new int[26];

        for(int i=0;i<n;i++)
            freq[word.charAt(i)-'a']++;

        Arrays.sort(freq);
        
        int count=0,push=1;
        int res=0;
        for(int i=25;i>=0;i--)
        {
            if (count>=8)
            {
                push++;
                count=0;
            }
            res+=freq[i]*push;
            count++;
        }

        return res;
    }
}