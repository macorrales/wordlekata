package dojo;


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
        }
        return result;
    }
}
