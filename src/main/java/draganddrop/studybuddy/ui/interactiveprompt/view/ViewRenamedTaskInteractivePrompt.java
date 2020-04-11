package draganddrop.studybuddy.ui.interactiveprompt.view;

/*
 * Logic of implementation:
 * IP will handle all interaction btw user and the window to get the final version of command
 * - FSM
 * Parser will handle to parsing of the command and create a command
 * command will execute the action
 * server display the response if needed
 * */

import static draganddrop.studybuddy.ui.interactiveprompt.InteractivePromptType.VIEW_DUPLICATE_TASK;

import java.text.ParseException;
import java.util.function.Predicate;

import draganddrop.studybuddy.logic.commands.delete.ViewRenamedTaskCommand;
import draganddrop.studybuddy.logic.commands.exceptions.CommandException;
import draganddrop.studybuddy.logic.parser.interactivecommandparser.exceptions.ViewRenamedTaskCommandException;
import draganddrop.studybuddy.model.task.Task;
import draganddrop.studybuddy.model.task.TaskRenamedPredicate;
import draganddrop.studybuddy.ui.interactiveprompt.InteractivePrompt;
import draganddrop.studybuddy.ui.interactiveprompt.InteractivePromptTerms;

/**
 * Represents a ViewRenamedTaskInteractivePrompt, which interacts with user to View duplicate tasks.
 */
public class ViewRenamedTaskInteractivePrompt extends InteractivePrompt {
    public static final String QUIT_COMMAND_MSG = "Successfully quited from filter renamed command.";
    private static final String END_OF_COMMAND_MSG = "Filtered renamed tasks successfully!";

    public ViewRenamedTaskInteractivePrompt() {
        super();
        this.interactivePromptType = VIEW_DUPLICATE_TASK;
    }

    @Override
    public String interact(String userInput) {
        if ("quit".equalsIgnoreCase(userInput)) {
            endInteract(QUIT_COMMAND_MSG);
            return reply;
        }

        switch (currentTerm) {

        case INIT:
            try {
                reply = "The renamed tasks will be filtered\n"
                    + "Please press enter again to make the desired changes.";
                currentTerm = InteractivePromptTerms.READY_TO_EXECUTE;
            } catch (ViewRenamedTaskCommandException ex) {
                reply = ex.getErrorMessage();
            }
            break;

        case READY_TO_EXECUTE:
            try {
                Predicate<Task> predicate = new TaskRenamedPredicate();
                ViewRenamedTaskCommand viewRenamedTaskCommand = new ViewRenamedTaskCommand(predicate);
                logic.executeCommand(viewRenamedTaskCommand);
                super.setEndOfCommand(true);
                endInteract(END_OF_COMMAND_MSG);
            } catch (CommandException | ParseException ex) {
                reply = ex.getMessage();
            }
            break;

        default:
        }
        return reply;
    }

    @Override
    public void endInteract(String msg) {
        this.reply = msg;
        super.setEndOfCommand(true);
    }

}