package parser;

import model.*;
import model.phrase.BinaryPhrase;
import model.phrase.BinaryPhraseBuilder;
import model.phrase.HorizontalBinaryPhrase;
import model.phrase.VerticalBinaryPhrase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryPhraseTest {

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
