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
    @DisplayName("No character matches")
    public void ifNothingMatchReturnsFiveDots()
    {
        assertEquals(".....",new Wordle("HELLO").guess("cigar"));
    }
}
