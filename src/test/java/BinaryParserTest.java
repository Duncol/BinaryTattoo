import model.BinaryWord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryParserTest {

    @Test
    public void parseWordTest() {
        // given
        final int defaultBitRange = 8;
        String rawWord = "miscellaneous";

        // when
        BinaryWord parsedWord = BinaryParser.parseBinaryWord(rawWord);

        // then
        assertEquals(rawWord.length(), parsedWord.length()/defaultBitRange);
    }

    @Test
    public void parseEmptyWordTest() {
        // given
        final int defaultBitRange = 8;
        String rawWord = "";

        // when
        BinaryWord parsedWord = BinaryParser.parseBinaryWord(rawWord);

        // then
        assertEquals(0, parsedWord.length()/defaultBitRange);
    }
}