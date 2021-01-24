import lombok.extern.slf4j.Slf4j;
import model.phrase.BinaryPhrase;
import model.phrase.BinaryPhraseBuilder;
import model.BinaryWord;
import model.phrase.PrintDirection;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class BinaryTattoo {

    public String toBinaryString(String source, String separator, PrintDirection printDirection) {

        final List<BinaryWord> words = Stream.of(source.split(separator))
                .map(BinaryParser::parseBinaryWord).collect(Collectors.toList());

        final BinaryPhrase phrase = new BinaryPhraseBuilder()
                .words(words)
                .separator(separator)
                .direction(printDirection)
                .build();

        return phrase.toString();
    }
}
