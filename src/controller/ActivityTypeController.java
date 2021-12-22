package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.ActivityType;
import utils.DataSerialize;
import utils.DataStore;
import utils.ListActivityTypeFactory;
import view.ActivityTypeView;

public class ActivityTypeController {
    private ActivityType model;
    private ActivityTypeView view;
    public ListActivityTypeFactory factory;
    private List<ActivityType> activityTypeList;

    public DataStore<DataSerialize> myDataDataStore;
    
    
    public ActivityTypeController(ActivityType model, ActivityTypeView view) {
        this.model = model;
        this.view = view;
        this.factory = new ListActivityTypeFactory();
        //this.activityTypeList = new ArrayList<>();
        this.myDataDataStore = new DataStore<>("ActivityTypeList.ser", DataSerialize::new);
        factory.setActivityTypeList(myDataDataStore.getData().activityTypeList);
        this.activityTypeList = factory.getActivityTypeList();
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

    public void addActivityTypeAction() {
        String name = view.gestionActivityTypeName("ajouter");
        boolean registration = (view.gestionActivityTypeRegitration().equalsIgnoreCase("o") ? true : false);
        ActivityType activity2Add = null;
        view.setError(null);
        view.setInformation(null);

        if(!name.isBlank() && !factory.get(name).isPresent()){
            view.setInformation("Le type d'activité ajoutée : " + factory.addActivityType(name, registration));
        }
        else
            view.setError("Le type d'activité exite déjà !");
    }

    public ActivityType removeActivityTypeAction() {
        String name = view.gestionActivityTypeName("supprimer");
        boolean confirmation = (view.gestionActivityTypeConfirmation().equalsIgnoreCase("o") ? true : false);
        ActivityType activity2Remove = null;
        if(confirmation && factory.get(name).isPresent()){
            // ActivityType activityType2Add = factory.remove(name).get();
            // activityTypeList.remove(activityType2Add);
            activity2Remove = factory.remove(name);
            //factory.setActivityTypeList(activityTypeList);
        }
        //return factory.getActivityTypeList();
        return activity2Remove;
    }

    public /*List<ActivityType>*/ void updateActivityTypeAction() {
        String name2Change = view.gestionActivityTypeName("modifier");
        String newName = view.gestionActivityTypeName("modifier","nouveau nom");
        boolean newRegistration = (view.gestionActivityTypeRegitration().equalsIgnoreCase("o") ? true : false);
        ActivityType activity2Update = null;

        if(!name2Change.isBlank() && !newName.isBlank() && name2Change.equalsIgnoreCase(newName) && factory.get(name2Change).isPresent()){
            activity2Update = factory.update(name2Change, newName, newRegistration);
        }
        //return factory.getActivityTypeList();
    }
    
}
