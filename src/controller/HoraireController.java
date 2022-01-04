package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import factory.CRUDGenericFactory;
import model.ActivityHoraire;
import model.ActivityType;
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
        view.setError(null);
        view.setInformation(null);

        ActivityHoraire activityHoraire2Display = null;

        LocalDateTime startDate = null;
        LocalDateTime endDate = null;

        if(startDateTexte.matches("(\\d{2}\\/\\d{2}\\/\\d{2}) (\\d{2}:\\d{2})")){
            startDate = LocalDateTime.parse(startDateTexte, DateTimeFormatter.ofPattern("dd/MM/yy HH:mm"));
        }

        if(endDateTexte.matches("(\\d{2}\\/\\d{2}\\/\\d{2}) (\\d{2}:\\d{2})")){
            endDate = LocalDateTime.parse(endDateTexte, DateTimeFormatter.ofPattern("dd/MM/yy HH:mm"));
        }
        ActivityType activityType = null;
        while(activityType == null){
            try{
                activityType = listActivityTypes.get(activityTypeId);
            }
            catch(IndexOutOfBoundsException ex){
                System.out.println("Aucun élement à cette index ! " + ex.getMessage());
                activityTypeId = Integer.parseInt(view.askUser("Entrer le numéro du type d'activité choisi : ", listActivityTypes))-1;
            }
        }

        if(startDate != null && endDate != null && !nameActivity.isBlank() && activityType != null){

            model.setStartDate(startDate);
            model.setEndDate(endDate);
            model.setName(nameActivity);
            model.setActivityType(activityType);

            activityHoraire2Display = factory.add(listActivityHoraires, model);

            view.setInformation("L'activité ajoutée à l'horaire : " + activityHoraire2Display);
        }
        else
            view.setError("Erreur de données !");
    }

    public void updateActivityHoraireAction(){
        String nameActivity2Change = view.askUser("Entrer le nom d'activité à modifier : ");
        String nameActivity = view.askUser("Entrer un nouveau nom d'activité : ");
        String startDateTexte = view.askUser("Entrer une nouvelle date et heure de début (dd/MM/yyyy hh:mm) : ");
        String endDateTexte = view.askUser("Entrer une nouvelle date et heure de fin (dd/MM/yyyy hh:mm) : ");
        int activityTypeId = Integer.parseInt(view.askUser("Entrer le numéro du type d'activité choisi : ", listActivityTypes))-1;
        view.setError(null);
        view.setInformation(null);

        ActivityHoraire activityHoraire2Display = null;

        LocalDateTime startDate = null;
        LocalDateTime endDate = null;

        model = factory.getBy(listActivityHoraires,ah -> ah.getName().equalsIgnoreCase(nameActivity2Change)).get();

        if(startDateTexte.matches("(\\d{2}\\/\\d{2}\\/\\d{2}) (\\d{2}:\\d{2})")){
            startDate = LocalDateTime.parse(startDateTexte, DateTimeFormatter.ofPattern("dd/MM/yy HH:mm"));
            model.setStartDate(startDate);
        }

        if(endDateTexte.matches("(\\d{2}\\/\\d{2}\\/\\d{2}) (\\d{2}:\\d{2})")){
            endDate = LocalDateTime.parse(endDateTexte, DateTimeFormatter.ofPattern("dd/MM/yy HH:mm"));
            model.setEndDate(endDate);
        }
        ActivityType activityType = null;
        while(activityType == null && activityTypeId != -1){
            try{
                activityType = listActivityTypes.get(activityTypeId);
            }
            catch(IndexOutOfBoundsException ex){
                System.out.println("Aucun élement à cette index ! " + ex.getMessage());
                activityTypeId = Integer.parseInt(view.askUser("Entrer le numéro du type d'activité choisi : ", listActivityTypes))-1;
            }
        }

        if(!nameActivity.isBlank()){
            model.setName(nameActivity);
        }

        if(activityTypeId != -1){
            model.setActivityType(activityType);
        }

        view.setInformation("L'activité modifiée à l'horaire : " + model);
    }

    public void removeActivityHoraireAction(){
        String startDateTexte = view.askUser("Entrer une date et heure de début (dd/MM/yyyy hh:mm) : ");
        String endDateTexte = view.askUser("Entrer une date et heure de fin (dd/MM/yyyy hh:mm) : ");
        String nameActivity = view.askUser("Entrer un nom d'activité : ");
        int activityTypeId = Integer.parseInt(view.askUser("Entrer le numéro du type d'activité choisi : ", listActivityTypes))-1;

        LocalDateTime startDate = LocalDateTime.parse(startDateTexte, DateTimeFormatter.ofPattern("dd/MM/yy HH:mm"));
        LocalDateTime endDate = LocalDateTime.parse(endDateTexte, DateTimeFormatter.ofPattern("dd/MM/yy HH:mm"));

        ActivityType activityType = listActivityTypes.get(activityTypeId);

        factory.add(listActivityHoraires, model);
    }
    
    
}