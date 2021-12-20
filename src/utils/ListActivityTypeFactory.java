package utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.ActivityType;

public class ListActivityTypeFactory implements ListActivityType{

    private List<ActivityType> activityTypeList;

    public ListActivityTypeFactory() {
        activityTypeList = new ArrayList<>();
    }

    public List<ActivityType> getActivityTypeList() {
        return activityTypeList;
    }

    public void setActivityTypeList(List<ActivityType> activityTypeList) {
        this.activityTypeList = activityTypeList;
    }

    @Override
    public ActivityType addActivityType(String name, boolean registration) {
        return new ActivityType(name, registration);
    }

    @Override
    public ActivityType get(String name) {
        ActivityType aTypeByName = null;
        for (ActivityType activityType : activityTypeList) {
            if(activityType.getName().equalsIgnoreCase(name)){
                aTypeByName = activityType;
            }
        }
        return aTypeByName;
    }

    @Override
    public ActivityType remove(String name) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
