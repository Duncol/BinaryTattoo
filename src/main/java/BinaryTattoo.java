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

    public static void main(String[] args) {

        final String input = "FORTIS FORTUNA ADJUVAT";
        final String separator = " ";

        final List<BinaryWord> words = Stream.of(input.split(separator))
                .map(BinaryParser::parseBinaryWord).collect(Collectors.toList());

        final BinaryPhrase phrase = new BinaryPhraseBuilder()
                .words(words)
                .separator(separator)
                .direction(PrintDirection.HORIZONTAL)
//                .direction(PrintDirection.VERTICAL)
                .build();

        System.out.println(phrase.toString());
    }
}
