class Solution {
    public String reversePrefix(String word, char ch) {
       char[] chArray = word.toCharArray();

        //Step-1 : 
        //Check if the given character exists in the given string
        int idx;
        for(idx=0; idx<chArray.length; idx++)
        {
            if(chArray[idx] == ch) break;
        }

        //Step-2:
        //If the given charater does not exist, 
        //return the given string.
        if(idx == chArray.length) return word;

        //Step-3:
        //Use 2 pointer approach to reverse the char array
        //& return as string.
        for(int left=0, right=idx; left<right; left++, right--)
        {
            char temp = chArray[left];
            chArray[left] = chArray[right]; 
            chArray[right] = temp;           
        }
        return new String(chArray); 
    }
}