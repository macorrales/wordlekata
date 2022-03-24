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
        var feedback = new StringBuilder(".....");
        var wordMutable = new StringBuilder(this.word);
      
        for(int i = 0; i < word.length(); i++) {      
            if (guess.charAt(i)==word.charAt(i)){
               feedback.setCharAt(i,Character.toUpperCase(guess.charAt(i)));
            } else if (wordMutable.toString().contains(guess.charAt(i) + "")) {
                feedback.setCharAt(i,Character.toLowerCase(guess.charAt(i)));
                wordMutable.setCharAt(wordMutable.toString().indexOf(guess.charAt(i)),'*');
            }
        }
        return feedback.toString();
    }
}
