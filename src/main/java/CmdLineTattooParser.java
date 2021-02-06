import lombok.extern.slf4j.Slf4j;
import model.TattooData;
import model.phrase.PrintDirection;
import org.apache.commons.cli.*;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
public class CmdLineTattooParser {

    public static final String INPUT_FLAG = "i";
    public static final String INPUT_FLAG_DESCRIPTION = "input string to be binarized";

    public static final String SEPARATOR_FLAG = "s";
    public static final String SEPARATOR_FLAG_DESCRIPTION = "word separator (default: space, i.e. ' ')";
    public static final String DEFAULT_SEPARATOR = " ";

    public static final String DIRECTION_FLAG = "d";
    public static final String DIRECTION_FLAG_DESCRIPTION = "print direction (default: vertical)";
    public static final PrintDirection DEFAULT_DIRECTION = PrintDirection.VERTICAL;

    public TattooData readArgs(String[] args) throws ParseException {
        Options cmdOptions = buildOptions();
        try {
            CommandLine parsedArgs = new DefaultParser().parse(cmdOptions, args);

            return parseTattooData(parsedArgs);
        } catch (IllegalArgumentException ex) {
            String generalMessage = String.format("Unable to parse input, cause: %s", ex.getMessage());
            printHelp(generalMessage, cmdOptions);
            throw new ParseException(generalMessage);
        }
    }

    private Options buildOptions() {
        Options cmdOptions = new Options();
        cmdOptions.addOption(new Option(INPUT_FLAG, true, INPUT_FLAG_DESCRIPTION));
        cmdOptions.addOption(new Option(SEPARATOR_FLAG, true, SEPARATOR_FLAG_DESCRIPTION));
        cmdOptions.addOption(new Option(DIRECTION_FLAG, true, DIRECTION_FLAG_DESCRIPTION));
        return cmdOptions;
    }

    private TattooData parseTattooData(CommandLine parsedArgs) {
        String tattooString = parsedArgs.getOptionValue(INPUT_FLAG);
        if (tattooString == null || tattooString.isEmpty()) {
            throw new IllegalArgumentException("Input tattoo string cannot be empty!");
        }
        if (tattooString.length() > 100000) {
            throw new IllegalArgumentException("Seriously? You don't have long enough body for this shit");
        }

        log.trace("Provided tattooString is correct: '{}'", tattooString);
        TattooData tattooData = new TattooData(tattooString);

        String separator = parsedArgs.getOptionValue(SEPARATOR_FLAG);
        if (separator == null || separator.isEmpty()) {
            log.warn("You've provided empty separator, defaulting to '{}'", DEFAULT_SEPARATOR);
            tattooData.separator(DEFAULT_SEPARATOR);
        } else {
            if (separator.length() > 100) {
                log.warn("Seriously? Such long separation should only be between you and this program..");
                tattooData.separator(DEFAULT_SEPARATOR);
            } else {
                log.trace("Provided separator is correct: '{}'", separator);
                tattooData.separator(separator);
            }
        }

        try {
            String directionString = parsedArgs.getOptionValue(DIRECTION_FLAG);
            tattooData.printDirection(PrintDirection.valueOf(directionString));
            log.trace("Provided print direction is correct: '{}'", directionString);
        } catch (IllegalArgumentException ex) {
            log.error("Invalid print direction specified, allowed values: {}, defaulting to: {}",
                    Arrays.stream(PrintDirection.values()).map(PrintDirection::toString).collect(Collectors.joining(",")),
                    DEFAULT_DIRECTION);
            tattooData.printDirection(DEFAULT_DIRECTION);
        }

        return tattooData;
    }

    private void printHelp(String generalMessage, Options options) {
        log.error(generalMessage);
        new HelpFormatter().printHelp("[packaged_jar]", options);
    }
}
