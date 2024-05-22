class Solution {
     List<List<String>> res = new ArrayList<>();
    
    // Check if a given string is a palindrome
    public boolean isPal(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    // Helper function to partition the string and store valid partitions
    public void part(int i, String s, List<String> currentPartition) {
        if (i == s.length()) {
            res.add(new ArrayList<>(currentPartition));
            return;
        }

        String temp = "";
        for (int j = i; j < s.length(); j++) {
            temp += s.charAt(j);
            if (isPal(temp)) {
                currentPartition.add(temp); // Choose
                part(j + 1, s, currentPartition); // Explore
                currentPartition.remove(currentPartition.size() - 1); // Un-choose
            }
        }
    }

    public List<List<String>> partition(String s) {
        part(0, s, new ArrayList<>());
        return res;
    }

}