package dojo;


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

    @Test 
    public void when_thereIsADirectMatch_expect_thatLetterInUppercase(){
           assertEquals("A....",new Wordle("aaaaa").guess("abbbb"));
    }

    @Test 
    public void when_thereIsADirectMatchOnChar2_expect_thatLetterInUppercase(){
           assertEquals(".A...",new Wordle("aaaaa").guess("babbb"));
    }
}
