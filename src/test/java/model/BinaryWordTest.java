package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BinaryWordTest {

    @Test
    public void appendOnlyTest() {

        int bitsCountInLetter = 8;

        // given
        BinaryLetter letterMock = mock(BinaryLetter.class);
        when(letterMock.length()).thenReturn(bitsCountInLetter);

        // when
        BinaryWord word = new BinaryWord();
        word.appendLetter(letterMock);

        // then
        assertEquals(bitsCountInLetter, word.length());
        assertTrue(word.hasNextLetter());
    }

    @Test
    public void appendAndPollTest() {

        // given
        int bitsCountInLetter = 8;

        BinaryLetter letterMock = mock(BinaryLetter.class);
        when(letterMock.length()).thenReturn(bitsCountInLetter);

        BinaryWord word = new BinaryWord();
        word.appendLetter(letterMock);

        // when
        BinaryLetter polledLetter = word.pollNextLetter();

        // then
        assertEquals(letterMock, polledLetter);
        assertEquals(0, word.length());
        assertFalse(word.hasNextLetter());
    }

    @Test
    public void lengthTest() {

        // given
        int bitsCountInLetter = 8;
        int lettersToAppend = 5;
        int lettersToPoll = 3;

        BinaryLetter letterMock = mock(BinaryLetter.class);
        when(letterMock.length()).thenReturn(bitsCountInLetter);

        BinaryWord word = new BinaryWord();

        // when
        for (int i = 0; i < lettersToAppend; i++) {
            word.appendLetter(letterMock);
        }

        for (int i = 0; i < lettersToPoll; i++) {
            word.pollNextLetter();
        }

        // then
        assertEquals((lettersToAppend-lettersToPoll)*bitsCountInLetter, word.length());
    }

    @Test
    public void pollBitEmptyLetterTest() {

        // given
        BinaryWord word = new BinaryWord();

        // when / then
        assertEquals(0, word.length());
        assertFalse(word.hasNextLetter());
        assertThrows(IllegalArgumentException.class, word::pollNextLetter);
    }
}