class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length;

        int[] letters_count = new int[26];
        for (char letter : letters) {
            letters_count[letter - 'a']++;
        }

        Map<String, Integer> words_scores = new HashMap<>();
        for (String word : words) {
            int s = 0;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                s += score[ch - 'a'];
            }
            words_scores.put(word, s);
        }

        return recursion(0, 0, words, letters_count, words_scores, n);
        
    }

    private int recursion(int cur_ind, int cur_score, String[] words, int[] letters_count, Map<String, Integer> words_scores, int n) {
        if (cur_ind == n) {
            return cur_score;
        }

        int res = cur_score;

        String word = words[cur_ind];
        int[] word_count = new int[26];
        boolean can_add_this_word = true;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            word_count[ch - 'a']++;
            if (word_count[ch - 'a'] > letters_count[ch - 'a']) {
                can_add_this_word = false;
                break;
            }
        }

        if (can_add_this_word) {
            for (int i = 0; i < 26; i++) {
                letters_count[i] -= word_count[i];
            }
            res = Math.max(res, recursion(cur_ind + 1, cur_score + words_scores.get(word), words, letters_count, words_scores, n));
            for (int i = 0; i < 26; i++) {
                letters_count[i] += word_count[i];
            }
        }

        res = Math.max(res, recursion(cur_ind + 1, cur_score, words, letters_count, words_scores, n));
        return res;
    }
}