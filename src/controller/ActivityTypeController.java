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
        ActivityType activity2Add = new ActivityType(name, registration);
        view.setError(null);
        view.setInformation(null);

        if(!name.isBlank() && !factory.getByName(name).isPresent()){
            view.setInformation("Le type d'activité ajoutée : " + factory.add(activityTypeList,activity2Add));
        }
        else
            view.setError("Le type d'activité exite déjà !");
    }

    public void removeActivityTypeAction() {
        String name = view.gestionActivityTypeName("supprimer");
        boolean confirmation = (view.gestionActivityTypeConfirmation().equalsIgnoreCase("o") ? true : false);
        view.setError(null);
        view.setInformation(null);
        Optional<ActivityType> activity2Remove = factory.getByName(name);

        if(confirmation && activity2Remove.isPresent()){
            // ActivityType activityType2Add = factory.remove(name).get();
            // activityTypeList.remove(activityType2Add);
            view.setInformation("Le type d'activité supprimée : " + factory.remove(activityTypeList,activity2Remove.get()));
            //factory.setActivityTypeList(activityTypeList);
        }
        else
            view.setError("Le type d'activité n'exite pas !");
        //return factory.getActivityTypeList();
    }

    public void updateActivityTypeAction() {
        String name2Change = view.gestionActivityTypeName("modifier");
        String newName = view.gestionActivityTypeName("modifier","nouveau nom");
        boolean newRegistration = (view.gestionActivityTypeRegitration().equalsIgnoreCase("o") ? true : false);
        ActivityType activity2Update = factory.getByName(name2Change).get();
        int activity2UpdateIndex = factory.getIndexByName(name2Change);
        view.setError(null);
        view.setInformation(null);

        if(!name2Change.isBlank() && !newName.isBlank() && !name2Change.equalsIgnoreCase(newName) && factory.getByName(name2Change).isPresent()){
            activity2Update.setName(newName);
            activity2Update.setRegistrationRequired(newRegistration);     
            view.setInformation("Le type d'activité modifée : " + activity2Update); //factory.update(activityTypeList,activity2Update,activity2UpdateIndex));
        }
        else{
            view.setError("Le type d'activité n'exite pas !");
        }
        //return factory.getActivityTypeList();
    }
    
}
