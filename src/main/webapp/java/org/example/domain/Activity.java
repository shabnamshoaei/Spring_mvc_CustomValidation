package src.main.webapp.java.org.example.domain;

import javax.validation.constraints.NotEmpty;

public class Activity {

    private long activityId;

    @NotEmpty
    private String activityTitle;

    public Activity() {
    }

    public Activity(long activityId, String activityTitle) {
        this.activityId = activityId;
        this.activityTitle = activityTitle;
    }

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    @Override
    public String toString() {
        return "Activity{" +
                ", activityId=" + activityId +
                ", activityTitle=" + activityTitle +
                '}';
    }
}
