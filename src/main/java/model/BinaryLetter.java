package model;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryLetter {

    private final Queue<Boolean> bits;

    private BinaryLetter(Builder b) {
        this.bits = b.bits;
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

    public static class Builder {
        private int bitRange = 8;
        private final Queue<Boolean> bits = new ArrayDeque<>();

        public Builder bitRange(int bitRange) {
            this.bitRange = bitRange;
            return this;
        }

        /**
         * Sets the next bit, from left to right.
         *
         * @param bit true (1), or false (0)
         */
        public Builder appendBit(boolean bit) {
            bits.add(bit);
            return this;
        }

        public BinaryLetter build() throws IllegalArgumentException {
            if (bitRange < 1 || bits.size() != bitRange) {
                throw new IllegalArgumentException("Invalid bit range!");
            }
            return new BinaryLetter(this);
        }
    }
}
