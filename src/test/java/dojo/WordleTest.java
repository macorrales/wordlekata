package dojo;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class WordleTest
{
    public static final String NOT_IN_DICTIONARY = "#####";
    
    @Test
    public void shouldAlwaysPass()
    {
        assertTrue(true);
    }

    @Test
    public void when_nothingMatches_expect_5dots(){
        assertEquals(".....",new Wordle("aaaaa").guess("bbbbb"));
    }
    
    @ParameterizedTest()
    @CsvSource(delimiter= '|',textBlock="""
            aaaaa|abbbb|A....|
            aaaaa|babbb|.A...|
            aaaaa|bbabb|..A..|
            aaaaa|bbbab|...A.|
            aaaaa|bbbba|....A|
            aaaaa|abbba|A...A|
               """
              )
    public void when_thereIsADirectMatchCombo_expect_thatComboInUppercase(
        String wordle, String guess, String feedback){
           assertEquals(feedback,new Wordle(wordle).guess(guess));
    }

    @ParameterizedTest()
    @CsvSource(delimiter= '|',textBlock="""
            abbbb|caccc|.a...|
            abbbb|ccacc|..a..
            abbbb|cccac|...a.
            abbbb|cccca|....a
            bbbba|acccc|a....
               """
              )
    public void when_thereIsAnIndirectMatchCombo_expect_thatComboInLowercase(
        String wordle, String guess, String feedback){
           assertEquals(feedback,new Wordle(wordle).guess(guess));
    }

    @ParameterizedTest()
    @CsvSource(delimiter= '|',textBlock="""
            	abbbb|cccaa|...a.
                abbbb|accca|A....
                aabbb|accaa|A..a.
                aabbb|aacaa|AA...
                aabbb|cccaa|...aa
                aaabb|ccaaa|..Aaa
                bbabb|aaaaa|..A..
                bbaaa|aaacc|aaA..
                bbaaa|aaaaa|..AAA
                ababb|caaac|.aA..
               """
              )
    public void when_thereIsAnIndirectMatchCombo_expect_thatComboInLowercase2(
        String wordle, String guess, String feedback){
           assertEquals(feedback,new Wordle(wordle).guess(guess));
    }

    @Test
    public void when_seventhAttemptIsMade_expect_feedbackToBe_allAT(){
        var myWordle = new Wordle("HELLO");
        
        assertEquals(".....",myWordle.guess("aaaaa"));
        assertEquals(".....",myWordle.guess("aaaaa"));        
        assertEquals(".....",myWordle.guess("aaaaa"));
        assertEquals(".....",myWordle.guess("aaaaa"));
        assertEquals(".....",myWordle.guess("aaaaa"));
        assertEquals(".....",myWordle.guess("aaaaa"));
        assertEquals("@@@@@",myWordle.guess("aaaaa"));
    }

        @Test
    public void when_InvalidAttemptsAreMade_TheyShouldNotBeCountedForMaxAttempt(){
        var myWordle = new Wordle("HELLO", List.of("AAAAA"));
        
        assertEquals(".....",myWordle.guess("aaaaa"));
        assertEquals(".....",myWordle.guess("aaaaa"));        
        assertEquals(".....",myWordle.guess("aaaaa"));
        assertEquals(NOT_IN_DICTIONARY,myWordle.guess("World"));
        assertEquals(".....",myWordle.guess("aaaaa"));
        assertEquals(".....",myWordle.guess("aaaaa"));
        assertEquals(".....",myWordle.guess("aaaaa"));
        assertEquals("@@@@@",myWordle.guess("aaaaa"));
    }
    
    @Test
    public void when_when_guessNotInWordList_expect_fiveOctothorpes_expect_fiveOctothorpes() {
        assertEquals(NOT_IN_DICTIONARY, new Wordle("HELLO", List.of("TRAIN")).guess("HELLO"));
    }

    @Test
    public void when_guessNotInWordList_expect_fiveOctothorpes() {
        assertEquals(NOT_IN_DICTIONARY, new Wordle("HELLO", List.of("TRAIN")).guess("WORLD"));
    }

    @Test
    public void when_guessIsInWorldlist_expect_checkToBeCaseInsensitive() {
        assertEquals(".....", new Wordle("HELLO", List.of("TRAIN")).guess("train"));
    }


}
