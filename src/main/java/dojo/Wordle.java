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
        String result = "";
        for(int i = 0; i < word.length(); i++) {      
            if (guess.charAt(i)==word.charAt(i)){
                result += Character.toUpperCase(guess.charAt(i));
            } else {
                result += ".";    
            }
                // return Character.toUpperCase(guess.charAt(0))+"....";
            // } else if (guess.charAt(1)==word.charAt(1)){
                // return "." + Character.toUpperCase(guess.charAt(1))+"...";
            // }
        }
        return result;
    }
}
