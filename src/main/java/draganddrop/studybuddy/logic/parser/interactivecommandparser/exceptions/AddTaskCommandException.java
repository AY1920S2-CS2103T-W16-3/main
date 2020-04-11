package draganddrop.studybuddy.logic.parser.interactivecommandparser.exceptions;

/**
 * Represents a AddTaskCommandException.
 */
public class AddTaskCommandException extends InteractiveCommandException {

    /**
     * Creates an AddTaskCommandException with {@code errorType}.
     *
     * @param errorType
     */
    public AddTaskCommandException(String errorType) {
        super(errorType);
    }
}