package dojo;

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
               """
              )
    public void when_thereIsAnIndirectMatchCombo_expect_thatComboInLowercase2(
        String wordle, String guess, String feedback){
           assertEquals(feedback,new Wordle(wordle).guess(guess));
    }
}
