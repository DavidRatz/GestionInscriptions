package controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import javax.lang.model.element.Element;

import factory.CRUDGenericFactory;
import model.ActivityHoraire;
import model.ActivityType;
import utils.DataSerialize;
import utils.DataStore;
import view.ActivityHoraireView;
import view.ViewGeneric;

public class HoraireController {
    private ActivityHoraire model;
    private ViewGeneric view = new ActivityHoraireView();
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

    public ViewGeneric getView() {
        return view;
    }

    public void setView(ViewGeneric view) {
        this.view = view;
    }

    public List<ActivityHoraire> getListActivityHoraires() {
        return listActivityHoraires;
    }

    public void setListActivityHoraires(List<ActivityHoraire> listActivityHoraires) {
        this.listActivityHoraires = listActivityHoraires;
    }

    public void addActivityHoraireAction(){
        String nameActivity = view.askUser("Entrer un nom d'activité : ");
        String startDateTexte = view.askUser("Entrer une date et heure de début (dd/MM/yyyy hh:mm) : ");
        String endDateTexte = view.askUser("Entrer une date et heure de fin (dd/MM/yyyy hh:mm) : ");
        int activityTypeId = Integer.parseInt(((ActivityHoraireView) view).askUserActivityType("Entrer le numéro du type d'activité choisi : ", listActivityTypes))-1;
        view.setError(null);
        view.setInformation(null);
        String error = null;

        ActivityHoraire activityHoraire2Display = null;

        LocalDateTime startDate = null;
        LocalDateTime endDate = null;

        if(startDateTexte.matches("(\\d{2}\\/\\d{2}\\/\\d{2}) (\\d{2}:\\d{2})")){
            startDate = LocalDateTime.parse(startDateTexte, DateTimeFormatter.ofPattern("dd/MM/yy HH:mm"));
        }
        else
            error += "La date et l'heure de début ne respecte pas le format ! ";

        if(endDateTexte.matches("(\\d{2}\\/\\d{2}\\/\\d{2}) (\\d{2}:\\d{2})")){
            endDate = LocalDateTime.parse(endDateTexte, DateTimeFormatter.ofPattern("dd/MM/yy HH:mm"));
        }
        else
            error += "La date et l'heure de fin ne respecte pas le format ! ";

        ActivityType activityType = null;
        while(activityType == null){
            try{
                activityType = listActivityTypes.get(activityTypeId);
            }
            catch(IndexOutOfBoundsException ex){
                System.out.println("Aucun type d'activité ! ");
                activityTypeId = Integer.parseInt(((ActivityHoraireView) view).askUserActivityType("Entrer le numéro du type d'activité choisi : ", listActivityTypes))-1;
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
            error += "Données saisies incorrectes ! ";
        
        view.setError("Erreur : " + error);
    }

    public void updateActivityHoraireAction(){
        String nameActivity2Change = view.askUser("Entrer le nom d'activité à modifier : ");
        String nameActivity = view.askUser("Entrer un nouveau nom d'activité : ");
        String jourHoraire2ChangeTexte = view.askUser("Entrer la date et heure de début à modifier (dd/MM/yyyy hh:mm) : ");
        String startDateTexte = view.askUser("Entrer une nouvelle date et heure de début (dd/MM/yyyy hh:mm) : ");
        String endDateTexte = view.askUser("Entrer une nouvelle date et heure de fin (dd/MM/yyyy hh:mm) : ");
        int activityTypeId = Integer.parseInt(((ActivityHoraireView) view).askUserActivityType("Entrer le numéro du type d'activité choisi : ", listActivityTypes))-1;
        view.setError(null);
        view.setInformation(null);
        setModel(null);
        String error = "";

        LocalDateTime startDate = null;
        LocalDateTime endDate = null;

        Predicate<ActivityHoraire> predicate = ah -> ah == null; 
        Predicate<ActivityHoraire> predicate2 = ah -> ah == null; 

        if(jourHoraire2ChangeTexte.matches("(\\d{2}\\/\\d{2}\\/\\d{2}) (\\d{2}:\\d{2})")){
            LocalDateTime jourHoraire2Change = LocalDateTime.parse(jourHoraire2ChangeTexte, DateTimeFormatter.ofPattern("dd/MM/yy HH:mm"));
            predicate2 = ah -> ah.getStartDate().equals(jourHoraire2Change);
            
        }
        else
            error += "La date et l'heure de début pour l'activité à modifier ne respecte pas le format ! ";

        predicate = ah -> ah.getName().equalsIgnoreCase(nameActivity2Change);
        
        Optional<ActivityHoraire> act = factory.getBy(listActivityHoraires,predicate.and(predicate2));
        if(act.isPresent())
            model = act.get();

        if(model != null){
            if(startDateTexte.matches("(\\d{2}\\/\\d{2}\\/\\d{2}) (\\d{2}:\\d{2})")){
                startDate = LocalDateTime.parse(startDateTexte, DateTimeFormatter.ofPattern("dd/MM/yy HH:mm"));
                model.setStartDate(startDate);
            }
            else
                error += "La date et l'heure de début inchangée car ne respecte pas le format ! ";

            if(endDateTexte.matches("(\\d{2}\\/\\d{2}\\/\\d{2}) (\\d{2}:\\d{2})")){
                endDate = LocalDateTime.parse(endDateTexte, DateTimeFormatter.ofPattern("dd/MM/yy HH:mm"));
                model.setEndDate(endDate);
            }
            else
                error += "La date et l'heure de fin inchangée car ne respecte pas le format ! ";

            ActivityType activityType = null;
            while(activityType == null && activityTypeId != -1){
                try{
                    activityType = listActivityTypes.get(activityTypeId);
                }
                catch(IndexOutOfBoundsException ex){
                    System.out.println("Ce type d'activité n'exite pas ! ");
                    activityTypeId = Integer.parseInt(((ActivityHoraireView) view).askUserActivityType("Entrer le numéro du type d'activité choisi : ", listActivityTypes))-1;
                }
            }

            if(!nameActivity.isBlank()){
                model.setName(nameActivity);
            }

            if(activityTypeId != -1){
                model.setActivityType(activityType);
            }

            view.setInformation("L'activité modifiée de l'horaire : " + model);
        }
        else
            error += "Aucune activité trouvée ! ";
        
        view.setError("Erreur : " + error);
    }

    public void removeActivityHoraireAction(){
        String nameActivity2Remove = view.askUser("Entrer un nom d'activité à supprimer de l'horaire : ");
        String jourHoraire2ChangeTexte = view.askUser("Entrer la date et heure de début à supprimer (dd/MM/yyyy hh:mm) : ");
        String error = "";

        view.setError(null);
        view.setInformation(null);
        setModel(null);

        Predicate<ActivityHoraire> predicate = ah -> ah == null; 
        Predicate<ActivityHoraire> predicate2 = ah -> ah == null; 

        if(jourHoraire2ChangeTexte.matches("(\\d{2}\\/\\d{2}\\/\\d{2}) (\\d{2}:\\d{2})")){
            LocalDateTime jourHoraire2Change = LocalDateTime.parse(jourHoraire2ChangeTexte, DateTimeFormatter.ofPattern("dd/MM/yy HH:mm"));
            predicate2 = ah -> ah.getStartDate().equals(jourHoraire2Change);   
        }
        else
            error += "La date et l'heure de début ne respecte pas le format ! ";

        predicate = ah -> ah.getName().equalsIgnoreCase(nameActivity2Remove);
        
        Optional<ActivityHoraire> act = factory.getBy(listActivityHoraires,predicate.and(predicate2));
        if(act.isPresent())
            model = act.get();

        if(model != null){
            factory.remove(listActivityHoraires, model);
            view.setInformation("L'activité supprimée de l'horaire : " + model);
        }
        else
            error += "Aucune activité trouvée ! ";
        
        view.setError("Erreur : " + error);
    }
    
    
}
