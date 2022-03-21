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

        var feedback = new StringBuilder(".....");

        for (int i=0;i<word.length();i++){
            if (guess.charAt(i)==word.charAt(i)){
                feedback.setCharAt(i,Character.toUpperCase(word.charAt(i)));
            }
        }
        return  feedback.toString();
   }
}
