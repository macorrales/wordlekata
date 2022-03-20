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
        return "feedback";
   }
}
