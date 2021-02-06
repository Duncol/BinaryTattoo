import model.TattooData;
import org.apache.commons.cli.ParseException;

public class Main {

    public static void main(String[] args) {
        try {
            TattooData tattooData = new CmdLineTattooParser().readArgs(args);
            System.out.println(BinaryTattoo.toBinaryString(tattooData));
        } catch (ParseException ex) {
            // CmdLineTattooParser print help message, we just want to 'Enjoy the silence' here
        }
    }
}
