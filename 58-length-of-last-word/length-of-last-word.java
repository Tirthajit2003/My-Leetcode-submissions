class Solution {
    public int lengthOfLastWord(String s) {
    
        int c = 0;
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == ' ' && c == 0) { // trim
                i--;
            } else if (s.charAt(i) != ' ') {
                i--;
                c++;
            } else {
                break;
            }
        }
        return c;
    }
}