package dojo;

/**
 * A Wordle engine
 * test Git repo
 */
public class Wordle {
    private Word word;
    private StringBuilder feedback;

    public Wordle(String word) {
        this.word = new Word(word);
    }
    
    // public
    public String guess(String guess) {
        this.feedback = new StringBuilder(".....");
        this.word.init();

        for(int i = 0; i < word.toString().length(); i++) {
            char guessedChar = guess.charAt(i);
            
            if (this.word.isDirectMatch(i, guessedChar)) {
                changeFeedbackForDirectMatch(guessedChar, i);
                this.word.markGuessedCharacter(guessedChar);
            } else if (this.word.isIndirectMatch(guessedChar)) {
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
}
