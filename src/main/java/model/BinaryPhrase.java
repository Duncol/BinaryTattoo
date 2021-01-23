package model;

import parser.PrintDirection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public abstract class BinaryPhrase {
    protected final boolean[][] bitMatrix;
    protected int heightCursor = 0;
    protected int widthCursor = 0;

    protected BinaryPhrase(int maxWidth, int maxHeight) {
        this.bitMatrix = new boolean[maxHeight][maxWidth];
    }

    protected abstract void appendBitWord(BinaryWord word);

    public static class Builder {
        private Collection<BinaryWord> words = new ArrayList<>();
        private PrintDirection direction = PrintDirection.HORIZONTAL;

        public Builder direction(PrintDirection d) {
            this.direction = d;
            return this;
        }

        public Builder words(Collection<BinaryWord> words) {
            this.words = words;
            return this;
        }

        public BinaryPhrase build() {
            int longestWordLength = words.stream().map(BinaryWord::length).reduce(Integer::sum).orElse(0);
            int wordCount = words.size();

            if (PrintDirection.HORIZONTAL.equals(direction)) {
                return new HorizontalBinaryPhrase(longestWordLength, wordCount, words);
            } else {
                return new VerticalBinaryPhrase(wordCount, longestWordLength, words);
            }
        }
    }

    public void printBits() {
        Stream.of(bitMatrix).map(Arrays::toString).forEach(System.out::println);
    }
}

