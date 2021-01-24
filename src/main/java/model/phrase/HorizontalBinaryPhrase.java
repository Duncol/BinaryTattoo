package model.phrase;

import model.BinaryLetter;
import model.BinaryWord;

import java.util.Collection;

public class HorizontalBinaryPhrase extends BinaryPhrase {

    public HorizontalBinaryPhrase(int maxWidth, int maxHeight, String separator, Collection<BinaryWord> words) {
        super(maxWidth, maxHeight, separator);
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
        }
        widthCursor = 0;
        heightCursor++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (boolean[] row : bitMatrix) {
            for (int j = 0; j < row.length; j++) {
                sb.append(row[j] ? '1' : '0');
                if ((j+1) % BIT_RANGE == 0) {
                    sb.append(separator);
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
