package dojo;

import java.util.Locale;
import java.util.stream.IntStream;

/**
 * A Wordle engine
 */
public class Wordle {
    private final String word;

    public Wordle(String word) {
        this.word = word.toLowerCase();
    }

    public String guess(String guessWord) {
        var guess = guessWord.toLowerCase();
        StringBuilder feedback = new StringBuilder(".....");
        IntStream.range(0, 5).forEach(i -> {
            char letter = guess.charAt(i);
            if (letter == word.charAt(i)) {
                feedback.setCharAt(i,Character.toUpperCase(letter));
                if (countLetter(feedback.toString(),letter)>=countLetter(word,letter)){
                    feedback.setCharAt(feedback.indexOf(Character.toString(letter)),'.');
                }
            } else if (word.contains(Character.toString(letter))){
                if (countLetter(feedback.toString().toLowerCase(),letter)<countLetter(word.toLowerCase(),letter)){
                    feedback.setCharAt(i, letter);
                }
            }
        });

        return feedback.toString();
    }

    private long countLetter(String s, final char c){
        return s.chars().filter(ch -> ch == c).count();
    }
}
