package model.phrase;

import model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryPhraseTest {

    private static final String SEPARATOR = " ";

    @Test
    public void emptyTest() {
        // given
        Collection<BinaryWord> words = new ArrayList<>();

        // when
        final BinaryPhrase phrase = new BinaryPhraseBuilder()
                .words(words)
                .direction(PrintDirection.VERTICAL)
                .build();

        // then
        String actual = phrase.toString();
        assertEquals("", actual);
    }

//    @Test
    public void verticalTest() {

        String expected = "01000110" + SEPARATOR + "01001111" + SEPARATOR + "01010010" + SEPARATOR + "01010100" + SEPARATOR + "01001001" + SEPARATOR + "01010011" + SEPARATOR + "00000000" + SEPARATOR + "\n" +
                "01000110" + SEPARATOR + "01001111" + SEPARATOR + "01010010" + SEPARATOR + "01010100" + SEPARATOR + "01010101" + SEPARATOR + "01001110" + SEPARATOR + "01000001 \n" +
                "01000001" + SEPARATOR + "01000100" + SEPARATOR + "01001010" + SEPARATOR + "01010101" + SEPARATOR + "01010110" + SEPARATOR + "01000001" + SEPARATOR + "01010100 ";

        // given
        Collection<BinaryWord> words = new ArrayList<>();

        // when
        final BinaryPhrase phrase = new BinaryPhraseBuilder()
                .words(words)
                .direction(PrintDirection.VERTICAL)
                .build();

        // then
        String actual = phrase.toString();
        assertEquals(expected, actual);
    }

//    @Test
    public void horizontalTest() {

        String expected = "0" + SEPARATOR + "0" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "1" + SEPARATOR + "1" + SEPARATOR + "1" + SEPARATOR + "\n" +
                "0" + SEPARATOR + "0" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "1" + SEPARATOR + "1" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "0" + SEPARATOR + "0" + SEPARATOR + "1" + SEPARATOR + "\n" +
                "0" + SEPARATOR + "0" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "1" + SEPARATOR + "1" + SEPARATOR + "1" + SEPARATOR + "\n" +
                "0" + SEPARATOR + "0" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "\n" +
                "0" + SEPARATOR + "0" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "1" + SEPARATOR + "1" + SEPARATOR + "1" + SEPARATOR + "\n" +
                "0" + SEPARATOR + "0" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "1" + SEPARATOR + "1" + SEPARATOR + "1" + SEPARATOR + "\n" +
                "0" + SEPARATOR + "0" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "1" + SEPARATOR + "1" + SEPARATOR + "1" + SEPARATOR + "\n" +
                "0" + SEPARATOR + "0" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "0" + SEPARATOR + "0" + SEPARATOR + "1" + SEPARATOR + "\n" +
                "\n" +
                "0" + SEPARATOR + "0" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "1" + SEPARATOR + "1" + SEPARATOR + "1" + SEPARATOR + "\n" +
                "0" + SEPARATOR + "0" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "0" + SEPARATOR + "1" + SEPARATOR + "1" + SEPARATOR + "\n" +
                "1" + SEPARATOR + "0" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "0" + SEPARATOR + "1" + SEPARATOR + "1" + SEPARATOR + "\n" +
                "0" + SEPARATOR + "0" + SEPARATOR + "1" + SEPARATOR + "\n" +
                "1" + SEPARATOR + "1" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "\n" +
                "0" + SEPARATOR + "0" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "1" + SEPARATOR + "1" + SEPARATOR + "1" + SEPARATOR + "\n" +
                "0" + SEPARATOR + "0" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "1" + SEPARATOR + "0" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "0" + SEPARATOR + "1" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "0" + SEPARATOR + "1" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "1" + SEPARATOR + "1" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "1" + SEPARATOR + "0" + SEPARATOR + "1" + SEPARATOR + "\n" +
                "\n" +
                "0" + SEPARATOR + "0" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "0" + SEPARATOR + "1" + SEPARATOR + "1" + SEPARATOR + "\n" +
                "0" + SEPARATOR + "0" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "0" + SEPARATOR + "0" + SEPARATOR + "1" + SEPARATOR + "\n" +
                "0" + SEPARATOR + "0" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "0" + SEPARATOR + "0" + SEPARATOR + "1" + SEPARATOR + "\n" +
                "0" + SEPARATOR + "0" + SEPARATOR + "0" + SEPARATOR + "\n" +
                "0" + SEPARATOR + "1" + SEPARATOR + "0" + SEPARATOR + "";

        // given
        Collection<BinaryWord> words = new ArrayList<>();

        // when
        final BinaryPhrase phrase = new BinaryPhraseBuilder()
                .words(words)
                .direction(PrintDirection.HORIZONTAL)
                .build();

        // then
        assertEquals(expected, phrase.toString());
    }
}
