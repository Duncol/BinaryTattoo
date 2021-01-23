import lombok.extern.slf4j.Slf4j;
import model.BinaryPhrase;
import model.BinaryWord;
import parser.BinaryParser;
import parser.PrintDirection;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class BinaryTattoo {

    public static void main(String[] args) {

        final String input = "FORTIS FORTUNA ADJUVAT";
        final String delimiter = " ";

        final List<BinaryWord> words = Stream.of(input.split(delimiter))
                .map(BinaryParser::parseBinaryWord).collect(Collectors.toList());

        final BinaryPhrase phrase = new BinaryPhrase.Builder()
                .words(words)
//                .direction(PrintDirection.HORIZONTAL)
                .direction(PrintDirection.VERTICAL)
                .build();

        phrase.printBits();
    }
}
