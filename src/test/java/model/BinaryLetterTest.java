package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryLetterTest {

    @Test
    public void appendOnlyTest() {

        // given
        BinaryLetter.Builder letterBuilder = new BinaryLetter.Builder().bitRange(1);
        letterBuilder.appendBit(true);

        // when
        BinaryLetter letter = letterBuilder.build();

        // then
        assertEquals(1, letter.length());
        assertTrue(letter.hasNextBit());
    }

    @Test
    public void appendAndPollTest() {

        // given
        boolean bit = true;
        BinaryLetter.Builder letterBuilder = new BinaryLetter.Builder().bitRange(1);
        letterBuilder.appendBit(true);
        BinaryLetter letter = letterBuilder.build();

        // when
        boolean polledBit = letter.pollNextBit();

        // then
        assertEquals(bit, polledBit);
        assertEquals(0, letter.length());
        assertFalse(letter.hasNextBit());
    }

    @Test
    public void lengthTest() {

        // given
        int bitsToAppend = 5;
        int bitsToPoll = 3;
        BinaryLetter.Builder letterBuilder = new BinaryLetter.Builder().bitRange(bitsToAppend);

        // when
        for (int i = 0; i < bitsToAppend; i++) {
            letterBuilder.appendBit(true);
        }

        BinaryLetter letter = letterBuilder.build();
        for (int i = 0; i < bitsToPoll; i++) {
            letter.pollNextBit();
        }

        // then
        assertEquals(2, letter.length());
    }

    @Test
    public void buildEmptyLetterTest() {

        // given
        BinaryLetter.Builder letterBuilder = new BinaryLetter.Builder();

        // when / then
        assertThrows(IllegalArgumentException.class, letterBuilder::build);
    }

    @Test
    public void negativeBitRangeTest() {

        // given
        BinaryLetter.Builder letterBuilder = new BinaryLetter.Builder().bitRange(-1);

        // when / then
        assertThrows(IllegalArgumentException.class, letterBuilder::build);
    }

    @Test
    public void incompleteLetterTest() {

        // given
        BinaryLetter.Builder letterBuilder = new BinaryLetter.Builder()
                                                .bitRange((byte)8)
                                                .appendBit(true)
                                                .appendBit(false);

        // when / then
        assertThrows(IllegalArgumentException.class, letterBuilder::build);
    }
}
