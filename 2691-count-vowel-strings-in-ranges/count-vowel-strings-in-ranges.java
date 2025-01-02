class Solution {
    public boolean isVowel(char x) 
    { 
        if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') 
            return true;
            
        return false;
    } 
    public int[] vowelStrings(String[] words, int[][] queries) {
        int q=queries.length;
        int res[]=new int[q];
        int n=words.length;
        int psum[]=new int[n];

        char s=words[0].charAt(0);
        char e=words[0].charAt(words[0].length()-1);

        if (isVowel(s) && isVowel(e)) psum[0]=1;

        for(int i=1;i<n;i++)
        {
            String st=words[i];
            if (isVowel(st.charAt(0)) && isVowel(st.charAt(st.length()-1)))
                psum[i]=psum[i-1]+1;

            else psum[i]=psum[i-1];
        }

        for(int i=0;i<q;i++)
        {
            int l=queries[i][0];
            int r=queries[i][1];

            res[i]=psum[r]-psum[l];
            if (isVowel(words[l].charAt(0)) && isVowel(words[l].charAt(words[l].length()-1)))
                res[i]+=1;

        }
        return res;

        

    }
}