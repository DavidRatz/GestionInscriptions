package controller;

import java.util.ArrayList;
import java.util.List;

import model.ActivityType;
import utils.DataSerialize;
import utils.DataStore;
import utils.ListActivityTypeFactory;
import view.ActivityTypeView;

public class ActivityTypeController {
    private ActivityType model;
    private ActivityTypeView view;
    private ListActivityTypeFactory factory;
    public List<ActivityType> activityTypeList;

    public DataStore<DataSerialize> myDataDataStore;
    
    
    public ActivityTypeController(ActivityType model, ActivityTypeView view) {
        this.model = model;
        this.view = view;
        this.factory = new ListActivityTypeFactory();
        //this.activityTypeList = new ArrayList<>();
        this.myDataDataStore = new DataStore<>("ActivityTypeList.ser", DataSerialize::new);
        activityTypeList = myDataDataStore.getData().activityTypeList;
    }

    public ActivityType getModel() {
        return model;
    }

    public void setModel(ActivityType model) {
        this.model = model;
    }

    public ActivityTypeView getView() {
        return view;
    }

    public void setView(ActivityTypeView view) {
        this.view = view;
    }

    public List<ActivityType> addActivityTypeAction() {
        String name = view.saisirActivityTypeName();
        boolean registration = (view.saisirActivityTypeRegitration().equalsIgnoreCase("o") ? true : false);

        if(registration && factory.get(name) == null){
            ActivityType activityType2Add = factory.addActivityType(name, registration);
            activityTypeList.add(activityType2Add);
            factory.setActivityTypeList(activityTypeList);
        }
        return factory.getActivityTypeList();
    }
    
}
