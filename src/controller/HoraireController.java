package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.ActivityHoraire;
import model.ActivityType;
import utils.CRUDGenericFactory;
import utils.DataSerialize;
import utils.DataStore;
import view.ActivityHoraireView;

public class HoraireController {
    private ActivityHoraire model;
    private ActivityHoraireView view;
    private CRUDGenericFactory<ActivityHoraire> factory;
    private List<ActivityHoraire> listActivityHoraires;
    private List<ActivityType> listActivityTypes;
    
    
    public HoraireController(ActivityHoraire model, ActivityHoraireView view, DataStore<DataSerialize> myDataDataStore) {
        this.model = model;
        this.view = view;
        factory = new CRUDGenericFactory<>();
        listActivityHoraires = myDataDataStore.getData().activityHoraires;
        listActivityTypes = myDataDataStore.getData().activityTypeList;
    }

    public ActivityHoraire getModel() {
        return model;
    }

    public void setModel(ActivityHoraire model) {
        this.model = model;
    }

    public ActivityHoraireView getView() {
        return view;
    }

    public void setView(ActivityHoraireView view) {
        this.view = view;
    }

    public List<ActivityHoraire> getListActivityHoraires() {
        return listActivityHoraires;
    }

    public void setListActivityHoraires(List<ActivityHoraire> listActivityHoraires) {
        this.listActivityHoraires = listActivityHoraires;
    }

    public void addActivityHoraireAction(){
        String startDateTexte = view.askUser("Entrer une date et heure de début (dd/MM/yyyy hh:mm) : ");
        String endDateTexte = view.askUser("Entrer une date et heure de fin (dd/MM/yyyy hh:mm) : ");
        String nameActivity = view.askUser("Entrer un nom d'activité : ");
        int activityTypeId = Integer.parseInt(view.askUser("Entrer le numéro du type d'activité choisi : ", listActivityTypes))-1;

        LocalDateTime startDate = LocalDateTime.parse(startDateTexte, DateTimeFormatter.ofPattern("dd/MM/yy HH:mm"));
        LocalDateTime endDate = LocalDateTime.parse(endDateTexte, DateTimeFormatter.ofPattern("dd/MM/yy HH:mm"));

        ActivityType activityType = listActivityTypes.get(activityTypeId);

        model.setStartDate(startDate);
        model.setEndDate(endDate);
        model.setName(nameActivity);
        model.setActivityType(activityType);

        factory.add(listActivityHoraires, model);
    }
    
    
}
