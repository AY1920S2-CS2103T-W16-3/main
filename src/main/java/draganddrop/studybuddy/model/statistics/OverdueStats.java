package draganddrop.studybuddy.model.statistics;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores statistics about number of overdue tasks
 */
public class OverdueStats {
    /**
     * A list containing daily number of overdue tasks
     */
    private List<Integer> overdueList;

    public OverdueStats() {
        this.initList();
    }

    public List<Integer> getOverdueCountList() {
        return overdueList;
    }

    public void setOverdueList(List<Integer> overdueList) {
        this.overdueList = overdueList;
    }

    /**
     * initializes an empty overdueCountList
     */
    public void initList() {
        overdueList = new ArrayList<>();
        for (int i = 0; i < 366; i++) {
            overdueList.add(0);
        }
    }

    /**
     * increments the completeLate count at current day index
     *
     * @param dayIndex the day in which the task is completed
     */
    public void addOverdue(int dayIndex) {
        int currentLateCount = overdueList.get(dayIndex);
        if (currentLateCount != 0) {
            overdueList.set(dayIndex, 1);
        } else {
            overdueList.set(dayIndex, currentLateCount + 1);
        }
    }

    /**
     * Returns number of task completed late on the given day
     *
     * @param dayIndex
     * @return number of tasks completed late on the given day
     */
    public int getDailyOverdueCount(int dayIndex) {
        return overdueList.get(dayIndex);
    }

}