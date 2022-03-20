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

    @Test
    public void aCharacterMatches(){
        assertEquals("A....",new Wordle("aaaaa").guess("abbbb"));
        assertEquals(".A...",new Wordle("aaaaa").guess("babbb"));
        assertEquals("..A..",new Wordle("aaaaa").guess("bbabb"));
        assertEquals("...A.",new Wordle("aaaaa").guess("bbbab"));
        assertEquals("....A",new Wordle("aaaaa").guess("bbbba"));
    }
}
