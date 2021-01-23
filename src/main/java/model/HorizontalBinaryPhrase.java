package model;

import java.util.Collection;

public class HorizontalBinaryPhrase extends BinaryPhrase {

    public HorizontalBinaryPhrase(int maxHeight, int maxWidth, Collection<BinaryWord> words) {
        super(maxWidth, maxHeight);
        words.forEach(this::appendBitWord);
    }

    @Override
    protected void appendBitWord(BinaryWord word) {

        while (word.hasNextLetter()) {
            BinaryLetter letter = word.pollNextLetter();
            while (letter.hasNextBit()) {
                boolean bit = letter.pollNextBit();
                bitMatrix[heightCursor][widthCursor] = bit;
                widthCursor++;
            }
            heightCursor++;
        }
    }
}
