package dojo;

/**
 * A Wordle engine
 * test Git repo
 */
public class Word {
    private final String word;
    private StringBuilder wordMutable;

    public Word(String word) {
        this.word = word.toLowerCase();
    }

    public void init()
    {
        this.wordMutable = new StringBuilder(this.word);
    }
    
    public String toString() {
        return this.word;
    }

    public boolean isDirectMatch(int index, char guessedChar) {
        return guessedChar == this.word.charAt(index);
    }

    
    public boolean isIndirectMatch(char guessedChar) {
      return this.wordMutable.toString().contains(Character.toString(guessedChar));
    }

    public void markGuessedCharacter(char guessedChar) {
        this.wordMutable.setCharAt(this.wordMutable.toString().indexOf(guessedChar),'*');
    }
}
