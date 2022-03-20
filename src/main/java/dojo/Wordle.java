package dojo;

/**
 * A Wordle engine
 */
public class Wordle {
    private String word;

    public Wordle(String word) {
        this.word = word;
    }
   public String guess(String guess){
        return "feedback";
   }
}
