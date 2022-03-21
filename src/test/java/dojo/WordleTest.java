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
    public void when_noLetterMatches_expect_responseIs5dots(){
        assertEquals(".....",new Wordle("HELLO").guess("xxxxx"));
    }

    @Test
    public void when_firstLetterIsADirectMatch_expect_responseIsLetterInUppercase(){
        assertEquals("A....",new Wordle("aaaaa").guess("abbbb"));

    }

    @Test
    public void when_secondIsAdirectMatch_expect_responseIsThatLetterInUppercase(){
        assertEquals(".A...",new Wordle("aaaaa").guess("babbb"));
    }
    

    
}
