package utils;

import model.ActivityType;

public interface ListActivityType {
    ActivityType addActivityType(String name, boolean registration);
    ActivityType get(String name);
    ActivityType remove(String name);
}
