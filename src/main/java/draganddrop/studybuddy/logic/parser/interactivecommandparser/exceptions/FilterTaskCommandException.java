package draganddrop.studybuddy.logic.parser.interactivecommandparser.exceptions;

/**
 * Represents a FilterTaskCommandException.
 */
public class FilterTaskCommandException extends InteractiveCommandException {

    /**
     * Creates a FilterTaskCommandException.
     *
     * @param errorType
     */
    public FilterTaskCommandException(String errorType) {
        super(errorType);
    }
}