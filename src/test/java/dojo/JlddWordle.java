package dojo;

import org.eclipse.collections.api.bag.primitive.MutableCharBag;
import org.eclipse.collections.impl.factory.Strings;
import org.eclipse.collections.impl.factory.primitive.CharBags;
import org.eclipse.collections.impl.string.immutable.CharAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JlddWordle
{
    @Test
    public void wordleTest()
    {
        Assertions.assertEquals(".....", new Wordle("aaaaa").guess("bbbbb"));
        Assertions.assertEquals("A....", new Wordle("aaaaa").guess("abbbb"));
        Assertions.assertEquals(".A...", new Wordle("aaaaa").guess("babbb"));
        Assertions.assertEquals("..A..", new Wordle("aaaaa").guess("bbabb"));
        Assertions.assertEquals("...A.", new Wordle("aaaaa").guess("bbbab"));
        Assertions.assertEquals("....A", new Wordle("aaaaa").guess("bbbba"));

        Assertions.assertEquals(".a...", new Wordle("abbbb").guess("caccc"));
        Assertions.assertEquals("..a..", new Wordle("abbbb").guess("ccacc"));
        Assertions.assertEquals("...a.", new Wordle("abbbb").guess("cccac"));
        Assertions.assertEquals("....a", new Wordle("abbbb").guess("cccca"));

        Assertions.assertEquals("A....", new Wordle("abbbb").guess("accca"));
        Assertions.assertEquals("A....", new Wordle("abbbb").guess("accaa"));
        Assertions.assertEquals("A..a.", new Wordle("aabbb").guess("accaa"));
        Assertions.assertEquals("AA...", new Wordle("aabbb").guess("aacaa"));
        Assertions.assertEquals("...aa", new Wordle("aabbb").guess("cccaa"));

        Assertions.assertEquals("..A..", new Wordle("bbabb").guess("aaaaa"));

        Assertions.assertEquals("AAAAA", new Wordle("aaaaa").guess("aaaaa"));
        Assertions.assertEquals("BRAVO", new Wordle("bravo").guess("bravo"));
        Assertions.assertEquals("..Aaa", new dojo.Wordle("aaabb").guess("ccaaa"));
        assertEquals("aaA..", new dojo.Wordle("bbaaa").guess("aaacc"));

    }

    record Wordle(String string)
    {
        Wordle(String string)
        {
            this.string = string.toLowerCase();
        }

        public String guess(String guess)
        {
            CharAdapter guessChars = Strings.asChars(guess.toLowerCase());
            CharAdapter hiddenChars = Strings.asChars(this.string);
            MutableCharBag remaining = hiddenChars
                    .injectIntoWithIndex(
                            CharBags.mutable.empty(),
                            (bag, each, i) -> guessChars.get(i) != each ? bag.with(each) : bag);
            return guessChars.collectWithIndex((each, i) -> hiddenChars.get(i) == each ?
                            Character.toUpperCase(each) : this.replaceDifferentPositionOrNoMatch(remaining, each))
                    .makeString("");
        }

        private char replaceDifferentPositionOrNoMatch(MutableCharBag remaining, char each)
        {
            return remaining.remove(each) ? each : '.';
        }
    }
}
