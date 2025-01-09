class Solution {
    public boolean isPrefix(String s,String pref)
    {
        if (s.length()<pref.length()) return false;
        for(int i=0;i<pref.length();i++)
        {
            if (pref.charAt(i)!=s.charAt(i)) return false;
        }
        return true;
    }
    public int prefixCount(String[] words, String pref) {
        int c=0;
        for(int i=0;i<words.length;i++)
        {
            if (isPrefix(words[i],pref)) c++;
        }
        return c;
    }
}