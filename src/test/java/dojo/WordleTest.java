package dojo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class WordleTest {
    @Test
    @DisplayName("No character matches")
    public void ifNothingMatchReturnsFiveDots() {
        assertEquals(".....", new Wordle("HELLO").guess("cigar"));
    }

    @Test
    public void aCharacterMatches() {
        assertEquals("A....", new Wordle("aaaaa").guess("abbbb"));
        assertEquals(".A...", new Wordle("aaaaa").guess("babbb"));
        assertEquals("..A..", new Wordle("aaaaa").guess("bbabb"));
        assertEquals("...A.", new Wordle("aaaaa").guess("bbbab"));
        assertEquals("....A", new Wordle("aaaaa").guess("bbbba"));
    }

    @Test
    void aCharacterIsIndirectMatch() {
        assertEquals(".a...", new Wordle("abbbb").guess("caccc"));
        assertEquals("..a..", new Wordle("abbbb").guess("ccacc"));
        assertEquals("...a.", new Wordle("abbbb").guess("cccac"));
        assertEquals("....a", new Wordle("abbbb").guess("cccca"));
    }

    @Test
    void aCharacterIsIndirectMatchButAlreadyReported() {
        assertEquals("A....", new Wordle("abbbb").guess("accca"));
        assertEquals("A....", new Wordle("abbbb").guess("accaa"));
        assertEquals("A..a.", new Wordle("aabbb").guess("accaa"));
        assertEquals("AA...", new Wordle("aabbb").guess("aacaa"));
        assertEquals("...aa", new Wordle("aabbb").guess("cccaa"));
        assertEquals("..A..", new Wordle("bbabb").guess("aaaaa"));
        assertEquals("..Aaa", new Wordle("aaabb").guess("ccaaa"));
        assertEquals("..Aaa", new dojo.Wordle("aaabb").guess("ccaaa"));
    }

    @Test
    void allMatches(){
        assertEquals("AAAAA", new Wordle("aaaaa").guess("aaaaa"));
        assertEquals("BRAVO", new Wordle("bravo").guess("bravo"));

    }
}
/*
        assertEquals("aaA..", new Wordle("bbaaa").guess("aaaaa"));



        assertEquals("aaA..", new Wordle("bbaaa").guess("aaaaa"));

*/


