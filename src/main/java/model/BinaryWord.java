package model;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryWord {

    private final Queue<BinaryLetter> letters = new ArrayDeque<>();

    public void appendLetter(BinaryLetter letter) {
        letters.add(letter);
    }

    public boolean hasNextLetter() {
        return !letters.isEmpty();
    }

    public BinaryLetter pollNextLetter() {
        BinaryLetter letter = letters.poll();
        if (letter == null) {
            throw new IllegalArgumentException("No letters left!");
        }
        return letter;
    }

    /**
     * Return the number of bits, that consists to the word
     *
     * @return number of bits
     */
    public int length() {
        return letters.stream().map(BinaryLetter::length).reduce(Integer::sum).orElse(0);
    }

    @Override
    public String toString() {
        return letters.stream()
                .map(BinaryLetter::toString)
                .reduce((letter1, letter2) -> letter1 + " " + letter2)
                .orElse("EMPTY");
    }
}
