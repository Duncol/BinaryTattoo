package model;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryLetter {

    private final Queue<Boolean> bits = new ArrayDeque<>();

    /**
     * Sets the next bit, from left to right.
     *
     * @param bit true (1), or false (0)
     */
    public void appendBit(boolean bit) {
        bits.add(bit);
    }

    public boolean hasNextBit() {
        return !bits.isEmpty();
    }

    public boolean pollNextBit() {
        Boolean bit = bits.poll();
        if (bit == null) {
            throw new IllegalArgumentException("No bits left!");
        }
        return bit;
    }

    /**
     * Return the number of bits, that consists to the letter
     *
     * @return number of bits
     */
    public int length() {
        return bits.size();
    }

    @Override
    public String toString() {
        return bits.stream()
                .map(bit -> bit ? "1" : "0")
                .reduce(String::concat)
                .orElse("!");
    }
}
