package dojo;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    public void when_noLetterMatches_expect_responseIs5dots(){
        assertEquals(".....",new Wordle("HELLO").guess("xxxxx"));
    }


    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock =  """
            aaaaa|abbbb|A....|
            aaaaa|babbb|.A...|
            aaaaa|bbabb|..A..|
            aaaaa|bbbab|...A.|
            aaaaa|bbbba|....A|
                """)
    public void when_anyLetterIsADirectMatch_expect_responseIsLetterInUppercase(String wordle,String guess, String feedback){
        assertEquals(feedback,new Wordle(wordle).guess(guess));

    }

    @Test
    public void when_secondIsAdirectMatch_expect_responseIsThatLetterInUppercase(){
        assertEquals(".A...",new Wordle("aaaaa").guess("babbb"));
    }



}
