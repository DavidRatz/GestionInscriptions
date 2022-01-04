package factory;

import java.util.Optional;

import model.ActivityType;

public interface ListActivityType {
    //ActivityType addActivityType(String name, boolean registration);
    int getIndexByName(String name);
    Optional<ActivityType> getByName(String name);
    //ActivityType remove(String name);
    //ActivityType update(String name2Change, String newName, boolean newRegistration);
}
