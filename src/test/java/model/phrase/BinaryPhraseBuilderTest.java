package model.phrase;

import model.BinaryWord;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryPhraseBuilderTest {

    @Test
    public void verticalTest() {

        // given
        Collection<BinaryWord> emptyWordCollection = new ArrayList<>();

        // when
        final BinaryPhrase phrase = new BinaryPhraseBuilder()
                .words(emptyWordCollection)
                .direction(PrintDirection.VERTICAL)
                .build();

        // then
        assertEquals(VerticalBinaryPhrase.class, phrase.getClass());
    }

    @Test
    public void horizontalTest() {

        // given
        Collection<BinaryWord> emptyWordCollection = new ArrayList<>();

        // when
        final BinaryPhrase phrase = new BinaryPhraseBuilder()
                .words(emptyWordCollection)
                .direction(PrintDirection.HORIZONTAL)
                .build();

        // then
        assertEquals(HorizontalBinaryPhrase.class, phrase.getClass());
    }
}
