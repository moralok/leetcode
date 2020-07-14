package string.unique_morse_code_words;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    private String[] morseMap = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> morseSet = new HashSet<>();
        for (String word : words) {
            String morse = wordToMorse(word);
            morseSet.add(morse);
        }
        return morseSet.size();
    }

    private String wordToMorse(String word) {
        StringBuilder sb = new StringBuilder();
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            sb.append(morseMap[index]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[] {"gin", "zen", "gig", "msg"};
        System.out.println(solution.uniqueMorseRepresentations(words));
    }
    
}