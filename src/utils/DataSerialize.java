package utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.ActivityType;

public class DataSerialize implements Serializable {
    public List<ActivityType> activityTypeList = new ArrayList<>();
}
