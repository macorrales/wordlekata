package dojo;
import java.util.List;
import java.util.ArrayList;

/**
 * A Wordle engine
 * test Git repo
 */
class Wordle {
    private Word word;
    private StringBuilder feedback;
    private int guessCounter = 0;
    private List legalWordList = new ArrayList();
    public static final int MAX_GUESSES = 6;
    public static final String TOO_MANY_TRIES = "@@@@@";
    public static final String NOT_IN_THE_DICTIONARY = "#####";

    public Wordle(String word) {
        this.word = new Word(word);
    }

    public Wordle(String word, List legalWordList) {
        this(word);
        this.legalWordList = legalWordList;
    }
    
    // public
    public String guess(String guess) {
        this.feedback = new StringBuilder(".....");
        this.word.init();
        StringBuilder guessMutable = new StringBuilder(guess);
        
        if(legalWordList.size() > 0 && 
           !legalWordList.contains(guess.toUpperCase())) {
            return NOT_IN_THE_DICTIONARY;
        }
        
        increaseGuessCounter();
        if (maxGuessReached()) {
            return TOO_MANY_TRIES;
        }

        for(int i = 0; i < word.toString().length(); i++) {
            char guessedChar = guessMutable.toString().charAt(i);
            
            if (this.word.isDirectMatch(i, guessedChar)) {
                changeFeedbackForDirectMatch(guessedChar, i);
                this.word.markGuessedCharacter(guessedChar);
                guessMutable.setCharAt(i, '#');
            }
        }

        for(int i = 0; i < word.toString().length(); i++) {  
           char guessedChar = guessMutable.toString().charAt(i);
            if (this.word.isIndirectMatch(guessedChar)) {
                changeFeedbackForIndirectMatch(guessedChar, i);
                this.word.markGuessedCharacter(guessedChar);
            }
        }
        return feedback.toString();
    }
    
    private void changeFeedbackForDirectMatch(char guessedChar, int index) {
        this.feedback.setCharAt(index, Character.toUpperCase(guessedChar));
    }

    
    private void changeFeedbackForIndirectMatch(char guessedChar, int index) {
        this.feedback.setCharAt(index, Character.toLowerCase(guessedChar));
    }

    private int increaseGuessCounter() {
        return ++guessCounter;
    }

    private boolean maxGuessReached() {
        return guessCounter > MAX_GUESSES;
    }
}
