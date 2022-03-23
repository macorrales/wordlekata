package dojo;

import org.eclipse.collections.impl.factory.Strings;

/**
 * A Wordle engine
 */
public class Wordle {
    private final String word;

    public Wordle(String word) {
        this.word = word.toLowerCase();
    }

    public String guess(String guess) {

        var guessChars = Strings.asChars(guess);
        var feedback = new StringBuilder(".....");

        guessChars.forEachWithIndex((letter, i) -> {
            if (characterMatchesAt(i, guess)) {
                feedback.setCharAt(i, directMatch(i));
            }
        });
        return feedback.toString();
    }

    private char directMatch(int pos) {
        return Character.toUpperCase(word.charAt(pos));
    }

    private boolean characterMatchesAt(int pos, String guess) {
        return guess.charAt(pos) == word.charAt(pos);
    }
}
