package dojo;

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
            } else if (word.contains(Character.toString(letter))){
                feedback.setCharAt(i, letter);
            }
        });

        return feedback.toString();
    }
}
