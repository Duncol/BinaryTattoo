package model.phrase;

import model.BinaryWord;

import java.util.ArrayList;
import java.util.Collection;

public class BinaryPhraseBuilder {

    private Collection<BinaryWord> words = new ArrayList<>();
    private PrintDirection direction = PrintDirection.HORIZONTAL;
    private String separator;

    public BinaryPhraseBuilder direction(PrintDirection d) {
        this.direction = d;
        return this;
    }

    public BinaryPhraseBuilder words(Collection<BinaryWord> words) {
        this.words = words;
        return this;
    }

    public BinaryPhraseBuilder separator(String separator) {
        this.separator = separator;
        return this;
    }

    public BinaryPhrase build() {
        int longestWordLength = words.stream().map(BinaryWord::length).reduce(Integer::max).orElse(0);
        int wordCount = words.size();

        if (PrintDirection.HORIZONTAL.equals(direction)) {
            return new HorizontalBinaryPhrase(longestWordLength, wordCount, separator, words);
        } else {
            return new VerticalBinaryPhrase(wordCount, longestWordLength, separator, words);
        }
    }
}
