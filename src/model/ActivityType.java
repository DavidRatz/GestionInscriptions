package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ActivityType implements Serializable{
    private String name;
    private Boolean registration;
    
    public ActivityType() {
    }

    public ActivityType(String name, Boolean registration) {
        this.name = name;
        this.registration = registration;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Boolean isRegistrationRequired() {
        return registration;
    }
    public void setRegistrationRequired(Boolean registration) {
        this.registration = registration;
    }

    @Override
    public String toString() {
        return "ActivityType [name=" + name + ", registration=" + registration + "]";
    }
    
    
}
