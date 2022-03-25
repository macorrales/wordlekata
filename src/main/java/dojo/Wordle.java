package dojo;

import org.eclipse.collections.impl.factory.Strings;

import java.util.Locale;

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
                if (countLetters(feedback.toString().toLowerCase(), letter) > countLetters(word, letter)) {
                    feedback.setCharAt(feedback.indexOf(letter + ""), '.');
                }
            } else if (word.contains(Character.toString(letter))) {
                if (countLetters(feedback.toString().toLowerCase(Locale.ROOT), letter) <
                        countLetters(word, letter)
                ) {
                    feedback.setCharAt(i, letter);
                }
            }
        });
        return feedback.toString();
    }

    private long countLetters(String s, char c) {
        return s.chars().filter(ch -> ch == c).count();
    }

    private char directMatch(int pos) {
        return Character.toUpperCase(word.charAt(pos));
    }

    private boolean characterMatchesAt(int pos, String guess) {
        return guess.charAt(pos) == word.charAt(pos);
    }
}
