import lombok.extern.slf4j.Slf4j;
import model.BinaryWord;
import model.TattooData;
import model.phrase.BinaryPhrase;
import model.phrase.BinaryPhraseBuilder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class BinaryTattoo {

    private static final String DEFAULT_SEPARAOR = " ";

    public static String toBinaryString(TattooData tattooData) {

        final List<BinaryWord> words = Stream.of(tattooData.tattooString().split(DEFAULT_SEPARAOR))
                .map(BinaryParser::parseBinaryWord).collect(Collectors.toList());

        final BinaryPhrase phrase = new BinaryPhraseBuilder()
                .words(words)
                .separator(tattooData.separator())
                .direction(tattooData.printDirection())
                .build();

        return phrase.toString();
    }
}
