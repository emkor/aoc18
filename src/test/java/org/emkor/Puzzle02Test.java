package org.emkor;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.emkor.Puzzle02.*;
import static org.junit.Assert.assertEquals;

public class Puzzle02Test {

    @Test
    public void hasThreeLettersTest() {
        assertEquals(false, hasThreeLetters("abcdef"));
        assertEquals(true, hasThreeLetters("bababc"));
        assertEquals(false, hasThreeLetters("abbcde"));
        assertEquals(true, hasThreeLetters("abcccd"));
        assertEquals(false, hasThreeLetters("aabcdd"));
        assertEquals(false, hasThreeLetters("abcdee"));
        assertEquals(true, hasThreeLetters("ababab"));
    }

    @Test
    public void hasTwoLettersTest() {
        assertEquals(false, hasTwoLetters("abcdef"));
        assertEquals(true, hasTwoLetters("bababc"));
        assertEquals(true, hasTwoLetters("abbcde"));
        assertEquals(false, hasTwoLetters("abcccd"));
        assertEquals(true, hasTwoLetters("aabcdd"));
        assertEquals(true, hasTwoLetters("abcdee"));
        assertEquals(false, hasTwoLetters("ababab"));
    }

    @Test
    public void countChecksumTest() {
        List<String> lines = Arrays.asList("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab");
        Integer expectedChecksum = 12;
        Integer actualChecksum = countChecksum(lines);
        assertEquals(expectedChecksum, actualChecksum);
    }
}