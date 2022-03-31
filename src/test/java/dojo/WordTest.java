package dojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class WordTest
{
    @Test
    public void shouldAlwaysPass()
    {
        assertTrue(true);
    }

    @Test
    public void buildWord()
    {
        assertEquals("word", new Word("word").toString());    
    }
}