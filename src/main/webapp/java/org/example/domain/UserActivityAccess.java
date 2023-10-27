package src.main.webapp.java.org.example.domain;

import java.sql.Time;

public class UserActivityAccess {

    private long userActivityid;
    private long userId;
    private long activityId;
    private Time startTime;
    private Time endTime;

    public UserActivityAccess (){}
    public UserActivityAccess (long userActivityid,long userId,long activityId,Time startTime,  Time endTime)
    {
        this.userActivityid=userActivityid;
        this.userId=userId;
        this.activityId=activityId;
        this.startTime=startTime;
        this.endTime=endTime;
    }

    public UserActivityAccess(long userid) {
        this.userId = userid;
    }
    public long getUserActivityid() {
        return userActivityid;
    }

    public void setUserActivityid(long userActivityid) {
        this.userActivityid = userActivityid;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "UserActivityAccess{" +
                " userActivityid=" + userActivityid +
                ", userId=" + userId +
                ", activityId=" + activityId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
