package draganddrop.studybuddy.testutil;

import java.time.LocalDateTime;

import draganddrop.studybuddy.logic.parser.TimeParser;
import draganddrop.studybuddy.model.StudyBuddy;
import draganddrop.studybuddy.model.module.Module;
import draganddrop.studybuddy.model.task.Task;
import draganddrop.studybuddy.model.task.TaskStatus;
import draganddrop.studybuddy.model.task.TaskType;

/**
 * represents a typical tasklist.
 */
public class TypicalTasks {
    public static Task[] getSampleTasks() {
        Module cs2103T = new Module("Software Engineering", "CS2103T");
        Module cs2101 = new Module("Effective Communication for Computing Professionals",
                "CS2101");
        LocalDateTime[] dateTimesOne = {TimeParser.parseDateTime("23:59 12/12/2020"),
                TimeParser.parseDateTime("23:59 21/12/2020")};
        LocalDateTime[] dateTimesTwo = {TimeParser.parseDateTime("23:59 12/04/2020"),
                TimeParser.parseDateTime("23:59 21/04/2020")};
        LocalDateTime creationDateTime = LocalDateTime.now();


        return new Task[]{
            new Task(cs2103T, TaskType.Assignment, "Ass 1", "taskDescription", 20.0,
                    TaskStatus.PENDING, dateTimesOne, 5.0, creationDateTime),
            new Task(cs2101, TaskType.Presentation, "Presentation 1",
                    "Presentation taskDescription", 20.0, TaskStatus.FINISHED, dateTimesOne,
                    3.0, creationDateTime),
            new Task(cs2103T, TaskType.Assignment, "Quiz 1", "Quiz taskDescription",
                    2.0, TaskStatus.PENDING, dateTimesTwo, 1.0, creationDateTime),
            new Task(cs2101, TaskType.Meeting, "Meeting 1", "Meeting desc", 20.0,
                    TaskStatus.PENDING, dateTimesTwo, 15.0, creationDateTime),
            new Task(cs2103T, TaskType.Assignment, "Quiz 1", "Quiz taskDescription",
                    2.0, TaskStatus.PENDING, dateTimesTwo, 1.0, creationDateTime),
        };
    }

    public static Task[] getSampleArchivedTasks() {
        Module cs2103T = new Module("Software Engineering", "CS2103T");
        Module cs2101 = new Module("Effective Communication for Computing Professionals",
                "CS2101");
        LocalDateTime[] dateTimesOne = {TimeParser.parseDateTime("23:59 12/12/2020"),
                TimeParser.parseDateTime("23:59 21/12/2020")};
        LocalDateTime[] dateTimesTwo = {TimeParser.parseDateTime("23:59 12/04/2020"),
                TimeParser.parseDateTime("23:59 21/04/2020")};
        LocalDateTime creationDateTime = LocalDateTime.now();


        return new Task[]{
            new Task(cs2103T, TaskType.Assignment, "Ass 2", "taskDescription", 20.0,
                    TaskStatus.PENDING, dateTimesOne, 5.0, creationDateTime),
            new Task(cs2101, TaskType.Presentation, "Presentation 2",
                    "Presentation taskDescription", 20.0, TaskStatus.FINISHED, dateTimesOne,
                    3.0, creationDateTime),
            new Task(cs2103T, TaskType.Assignment, "Quiz 2", "Quiz taskDescription",
                    2.0, TaskStatus.PENDING, dateTimesTwo, 1.0, creationDateTime),
            new Task(cs2101, TaskType.Meeting, "Meeting 2", "Meeting desc", 20.0,
                    TaskStatus.PENDING, dateTimesTwo, 15.0, creationDateTime),
            new Task(cs2103T, TaskType.Assignment, "Quiz 2", "Quiz taskDescription",
                    2.0, TaskStatus.PENDING, dateTimesTwo, 1.0, creationDateTime),
        };
    }

    public static StudyBuddy getTypicalTaskList() {
        StudyBuddy sampleAb = new StudyBuddy();
        for (Task sampleTask : getSampleTasks()) {
            sampleAb.addTask(sampleTask);
        }
        for (Task sampleTask : getSampleArchivedTasks()) {
            sampleAb.addArchiveTask(sampleTask);
        }
        return sampleAb;
    }
}