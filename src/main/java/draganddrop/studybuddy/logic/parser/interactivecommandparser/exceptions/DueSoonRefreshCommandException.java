package draganddrop.studybuddy.logic.parser.interactivecommandparser.exceptions;

/**
 * Represents a DueSoonRefreshCommandException.
 *
 * @@author Souwmyaa Sabarinathann
 */
public class DueSoonRefreshCommandException extends InteractiveCommandException {

    /**
     * Creates a DueSoonRefreshCommandException.
     *
     * @param errorType
     */
    public DueSoonRefreshCommandException(String errorType) {
        super(errorType);
    }
}
