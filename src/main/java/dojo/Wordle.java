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

    public String guess(String guess) {
        StringBuilder feedback = new StringBuilder(".....");
        IntStream.range(0, 5).forEach(i -> {
            if (guess.charAt(i) == word.charAt(i)) {
                feedback.setCharAt(i,word.toUpperCase().charAt(i));
            }
        });

        return feedback.toString();
    }
}
