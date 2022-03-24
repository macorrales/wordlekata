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
               """
              )
    public void when_thereIsADirectMatchOnAny_expect_thatLetterInUppercase(
        String wordle, String guess, String feedback){
           assertEquals(feedback,new Wordle(wordle).guess(guess));
    }

}
