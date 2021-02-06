package model.phrase;

import model.BinaryWord;

public abstract class BinaryPhrase {
    protected static final int BIT_RANGE = 8;

    protected final boolean[][] bitMatrix;
    protected int heightCursor = 0;
    protected int widthCursor = 0;
    protected final String separator;

    protected BinaryPhrase(int maxWidth, int maxHeight, String separator) {
        this.bitMatrix = new boolean[maxHeight][maxWidth];
        this.separator = separator;
    }

    protected abstract void appendBitWord(BinaryWord word);
}

