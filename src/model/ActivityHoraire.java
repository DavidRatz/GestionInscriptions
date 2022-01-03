package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ActivityHoraire implements Serializable {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String name;
    private ActivityType activityType;

    public ActivityHoraire(LocalDateTime startDate, LocalDateTime endDate, String name, ActivityType activityType) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.activityType = activityType;
    }

    public ActivityHoraire() {
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ActivityType getActivityType() {
        return activityType;
    }
    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    @Override
    public String toString() {
        return "ActivityHoraire [activityType=" + activityType + ", endDate=" + endDate + ", name=" + name
                + ", startDate=" + startDate + "]";
    }
    
    
}
