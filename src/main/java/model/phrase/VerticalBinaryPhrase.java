package model.phrase;

import model.BinaryLetter;
import model.BinaryWord;

import java.util.Collection;

public class VerticalBinaryPhrase extends BinaryPhrase {

    public VerticalBinaryPhrase(int maxWidth, int maxHeight, String separator, Collection<BinaryWord> words) {
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
                heightCursor++;
            }
        }
        heightCursor = 0;
        widthCursor++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bitMatrix.length; i++) {
            boolean[] row = bitMatrix[i];
            for (boolean b : row) {
                sb.append(b ? '1' : '0').append(separator);
            }
            if ((i+1) % BIT_RANGE == 0) {
                sb.append("\n");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
