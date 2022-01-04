import java.util.Arrays;
import java.util.List;

import controller.ActivityTypeController;
import controller.HoraireController;
import factory.ListActivityTypeFactory;
import model.ActivityHoraire;
import model.ActivityType;
import utils.DataSerialize;
import utils.DataStore;
import view.ActivityHoraireView;
import view.ActivityTypeView;

public class App {
    public static void main(String[] args) throws Exception {
        DataStore<DataSerialize> myDataDataStore = new DataStore<>("ActivityTypeList.ser", DataSerialize::new);
        ActivityTypeController activityTypeController = new ActivityTypeController(new ActivityType(),new ActivityTypeView(),myDataDataStore);
        HoraireController horaireController = new HoraireController(new ActivityHoraire(),new ActivityHoraireView(),myDataDataStore);

        System.out.println(Arrays.asList(activityTypeController.factory.getActivityTypeList()));
        //List<ActivityType> activityList = activityTypeController.addActivityTypeAction();
        // for (int i = 0; i < 5; i++) {
        //     activityTypeController.addActivityTypeAction();
        // }
        

        if(activityTypeController.getView().getError() != null){
            System.out.println(activityTypeController.getView().getError());
        }
        
        if(activityTypeController.getView().getInformation() != null){
            System.out.println(activityTypeController.getView().getInformation());
        }

        System.out.println(Arrays.asList(activityTypeController.factory.getActivityTypeList()));

        //activityTypeController.updateActivityTypeAction();

        if(activityTypeController.getView().getError() != null){
            System.out.println(activityTypeController.getView().getError());
        }
        
        if(activityTypeController.getView().getInformation() != null){
            System.out.println(activityTypeController.getView().getInformation());
        }

        //activityTypeController.removeActivityTypeAction();

        if(activityTypeController.getView().getError() != null){
            System.out.println(activityTypeController.getView().getError());
        }

        if(activityTypeController.getView().getInformation() != null){
            System.out.println(activityTypeController.getView().getInformation());
        }

        System.out.println(Arrays.asList(activityTypeController.factory.getActivityTypeList()));

        System.out.println("Liste d'horaire : ");
        System.out.println(Arrays.asList(horaireController.getListActivityHoraires()));

        //horaireController.addActivityHoraireAction();

        if(horaireController.getView().getError() != null){
            System.out.println(horaireController.getView().getError());
        }

        if(horaireController.getView().getInformation() != null){
            System.out.println(horaireController.getView().getInformation());
        }

        System.out.println(Arrays.asList(horaireController.getListActivityHoraires()));

        horaireController.updateActivityHoraireAction();

        if(horaireController.getView().getError() != null){
            System.out.println(horaireController.getView().getError());
        }

        if(horaireController.getView().getInformation() != null){
            System.out.println(horaireController.getView().getInformation());
        }

        System.out.println(Arrays.asList(horaireController.getListActivityHoraires()));

        myDataDataStore.save();

        
    }
}
