package dojo;

import java.util.Locale;

/**
 * A Wordle engine
 */
public class Wordle {
    private final String word;

    public Wordle(String word) {
        this.word = word.toLowerCase();
    }

    public String guess(String guess){
        if (guess.charAt(0)==word.charAt(0)){
            return Character.toUpperCase(guess.charAt(0))+"....";
        }
        return ".....";
    }
}
