import java.util.Arrays;
import java.util.List;

import controller.ActivityTypeController;
import controller.HoraireController;
import controller.HorairePersonneController;
import controller.PersonneController;
import factory.ListActivityTypeFactory;
import model.ActivityHoraire;
import model.ActivityType;
import model.HorairePersonne;
import model.Personne;
import utils.DataSerialize;
import utils.DataStore;
import view.ActivityHoraireView;
import view.ActivityTypeView;
import view.HorairePersonneView;
import view.ViewGeneric;

public class App {
    public static void main(String[] args) throws Exception {
        DataStore<DataSerialize> myDataDataStore = new DataStore<>("ActivityTypeList.ser", DataSerialize::new);
        ActivityTypeController activityTypeController = new ActivityTypeController(new ActivityType(),new ActivityTypeView(),myDataDataStore);
        HoraireController horaireController = new HoraireController(new ActivityHoraire(),new ActivityHoraireView(),myDataDataStore);
        PersonneController personneController = new PersonneController(new Personne(), new ViewGeneric(), myDataDataStore);
        HorairePersonneController horairePersonneController = new HorairePersonneController(new HorairePersonne(),new HorairePersonneView(),myDataDataStore);

        try{
            //#region ACTIVITY TYPE

            System.out.println("Liste de tye d'activité : ");
            System.out.println(Arrays.asList(activityTypeController.factory.getActivityTypeList()));

            for (int i = 0; i < 3; i++) {
                activityTypeController.addActivityTypeAction();
            }
            

            if(activityTypeController.getView().getError() != null){
                System.out.println(activityTypeController.getView().getError());
            }
            
            if(activityTypeController.getView().getInformation() != null){
                System.out.println(activityTypeController.getView().getInformation());
            }

            System.out.println("Liste de tye d'activité : ");
            System.out.println(Arrays.asList(activityTypeController.factory.getActivityTypeList()));

            //activityTypeController.updateActivityTypeAction();

            if(activityTypeController.getView().getError() != null){
                System.out.println(activityTypeController.getView().getError());
            }
            
            if(activityTypeController.getView().getInformation() != null){
                System.out.println(activityTypeController.getView().getInformation());
            }

            System.out.println("Liste de tye d'activité : ");
            System.out.println(Arrays.asList(activityTypeController.factory.getActivityTypeList()));

            //activityTypeController.removeActivityTypeAction();

            if(activityTypeController.getView().getError() != null){
                System.out.println(activityTypeController.getView().getError());
            }

            if(activityTypeController.getView().getInformation() != null){
                System.out.println(activityTypeController.getView().getInformation());
            }

            System.out.println("Liste de tye d'activité : ");
            System.out.println(Arrays.asList(activityTypeController.factory.getActivityTypeList()));
            
            //#endregion
            //#region HORAIRE

            System.out.println("Liste d'horaire : ");
            System.out.println(Arrays.asList(horaireController.getListActivityHoraires()));

            horaireController.addActivityHoraireAction();

            if(horaireController.getView().getError() != null){
                System.out.println(horaireController.getView().getError());
            }

            if(horaireController.getView().getInformation() != null){
                System.out.println(horaireController.getView().getInformation());
            }

            System.out.println("Liste d'horaire : ");
            System.out.println(Arrays.asList(horaireController.getListActivityHoraires()));

            // horaireController.updateActivityHoraireAction();

            if(horaireController.getView().getError() != null){
                System.out.println(horaireController.getView().getError());
            }

            if(horaireController.getView().getInformation() != null){
                System.out.println(horaireController.getView().getInformation());
            }

            System.out.println("Liste d'horaire : ");
            System.out.println(Arrays.asList(horaireController.getListActivityHoraires()));

            //horaireController.removeActivityHoraireAction();

            if(horaireController.getView().getError() != null){
                System.out.println(horaireController.getView().getError());
            }

            if(horaireController.getView().getInformation() != null){
                System.out.println(horaireController.getView().getInformation());
            }

            System.out.println("Liste d'horaire : ");
            System.out.println(Arrays.asList(horaireController.getListActivityHoraires()));
            //#endregion
            //#region PERSONNE

            System.out.println("Liste de personnes : ");
            System.out.println(Arrays.asList(personneController.getListPersonnes()));

            personneController.addPersonneAction();

            if(horaireController.getView().getError() != null){
                System.out.println(horaireController.getView().getError());
            }

            if(horaireController.getView().getInformation() != null){
                System.out.println(horaireController.getView().getInformation());
            }

            System.out.println("Liste de personnes : ");
            System.out.println(Arrays.asList(personneController.getListPersonnes()));

            // personneController.updatePersonneAction();

            // if(horaireController.getView().getError() != null){
            //     System.out.println(horaireController.getView().getError());
            // }

            // if(horaireController.getView().getInformation() != null){
            //     System.out.println(horaireController.getView().getInformation());
            // }

            // System.out.println("Liste de personnes : ");
            // System.out.println(Arrays.asList(personneController.getListPersonnes()));

            // personneController.removePersonneAction();

            // if(horaireController.getView().getError() != null){
            //     System.out.println(horaireController.getView().getError());
            // }

            // if(horaireController.getView().getInformation() != null){
            //     System.out.println(horaireController.getView().getInformation());
            // }

            // System.out.println("Liste de personnes : ");
            // System.out.println(Arrays.asList(personneController.getListPersonnes()));
            
            //#endregion
            //#region Inscription stage

            System.out.println("Liste d'inscription à un stage : ");
            System.out.println(Arrays.asList(horairePersonneController.getlHorairePersonnes()));

            horairePersonneController.addHorairePersonneAction();

            if(horairePersonneController.getView().getError() != null){
                System.out.println(horairePersonneController.getView().getError());
            }

            if(horairePersonneController.getView().getInformation() != null){
                System.out.println(horairePersonneController.getView().getInformation());
            }

            System.out.println("Liste d'inscription à un stage : ");
            System.out.println(Arrays.asList(horairePersonneController.getlHorairePersonnes()));

            //#endregion
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        finally{
            myDataDataStore.save();
        }

        
    }
}
