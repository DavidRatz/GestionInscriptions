package utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

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
        ActivityType activityType2Add = new ActivityType(name, registration);
        activityTypeList.add(activityType2Add);
        return activityType2Add;
    }

    @Override
    public int getIndex(String name) {
        return IntStream.range(0, activityTypeList.size()).filter(i -> activityTypeList.get(i).getName().equalsIgnoreCase(name)).findFirst().orElse(-1);
    }

    @Override
    public Optional<ActivityType> get(String name) {
        // ActivityType aTypeByName = null;
        // for (ActivityType activityType : activityTypeList) {
        //     if(activityType.getName().equalsIgnoreCase(name)){
        //         aTypeByName = activityType;
        //     }
        // }
        // return aTypeByName;
        
        return activityTypeList.stream().filter(at -> at.getName().equalsIgnoreCase(name)).findAny();
    }

    @Override
    public ActivityType remove(String name) {
        //return activityTypeList.stream().filter(at -> at.getName().equalsIgnoreCase(name)).findAny();
        activityTypeList.remove(this.get(name).get());
        return this.get(name).get();
    }

    @Override
    public ActivityType update(String name2Change, String newName, boolean newRegistration) {
        ActivityType activityType = null;
        Optional<ActivityType> activityTypeByName = this.get(name2Change);
        if(activityTypeByName.isPresent()){
            activityType = activityTypeByName.get();
            activityType.setName(newName);
            activityType.setRegistrationRequired(newRegistration);
        }
        activityTypeList.set(getIndex(name2Change), activityType);
        return activityType;
    }
    
}
