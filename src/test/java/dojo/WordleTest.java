package dojo;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test void aCharacterIsPresentInAnotherPosition(){

        assertEquals(".a...", new Wordle("abbbb").guess("caccc"));
        assertEquals("..a..", new Wordle("abbbb").guess("ccacc"));
        assertEquals("...a.", new Wordle("abbbb").guess("cccac"));
        assertEquals("....a", new Wordle("abbbb").guess("cccca"));
    }

    
}
/*

        assertEquals("A....", new Wordle("abbbb").guess("accca"));
        assertEquals("A....", new Wordle("abbbb").guess("accaa"));
        assertEquals("A..a.", new Wordle("aabbb").guess("accaa"));
        assertEquals("AA...", new Wordle("aabbb").guess("aacaa"));
        assertEquals("...aa", new Wordle("aabbb").guess("cccaa"));

        assertEquals("..A..", new Wordle("bbabb").guess("aaaaa"));

        assertEquals("AAAAA", new Wordle("aaaaa").guess("aaaaa"));
        assertEquals("BRAVO", new Wordle("bravo").guess("bravo"));

*/
