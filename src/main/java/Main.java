import model.phrase.PrintDirection;

public class Main {

    private static final PrintDirection DIRECTION = PrintDirection.VERTICAL;
    private static final String SEPARATOR = " ";

    public static void main(String[] args) {
        System.out.println(new BinaryTattoo().toBinaryString(args[0], SEPARATOR, DIRECTION));
    }
}
