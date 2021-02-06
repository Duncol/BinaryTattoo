import lombok.extern.slf4j.Slf4j;
import model.BinaryLetter;
import model.BinaryWord;

@Slf4j
public class BinaryParser {

    public static BinaryWord parseBinaryWord(String input) {
        log.info("Parsing input: {}", input);
        long startTime = System.currentTimeMillis();

        BinaryWord word = new BinaryWord();
        for (char c : input.toCharArray()) {
            word.appendLetter(parseBinaryLetter(c));
        }

        long duration = System.currentTimeMillis() - startTime;
        log.info("Parsing complete, result: {} (took: {}ms)", word, duration);
        return word;
    }

    private static BinaryLetter parseBinaryLetter(char input) {
        int divider = 1;

        // Find closest binary incrementation, i.e. 8, 16, 32 etc...
        while (input > divider) {
            divider *= 2;
        }

        BinaryLetter.Builder letterBuilder = new BinaryLetter.Builder();
        while (divider > 0) {
            if (input >= divider) {
                letterBuilder.appendBit(true);
                input -= divider;
            } else {
                letterBuilder.appendBit(false);
            }
            divider /= 2;
        }

        return letterBuilder.build();
    }
}
