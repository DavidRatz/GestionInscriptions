import java.util.Arrays;
import java.util.List;

import controller.ActivityTypeController;
import model.ActivityType;
import utils.DataSerialize;
import utils.DataStore;
import utils.ListActivityTypeFactory;
import view.ActivityTypeView;

public class App {
    public static void main(String[] args) throws Exception {
        ActivityTypeController activityTypeController = new ActivityTypeController(new ActivityType(),new ActivityTypeView());
        System.out.println(Arrays.asList(activityTypeController.factory.getActivityTypeList()));
        //List<ActivityType> activityList = activityTypeController.addActivityTypeAction();
        activityTypeController.addActivityTypeAction();
        
        if(activityTypeController.getView().getInformation() != null){
            System.out.println(activityTypeController.getView().getInformation());
        }

        System.out.println(Arrays.asList(activityTypeController.factory.getActivityTypeList()));

        ActivityType activityRemoved = activityTypeController.removeActivityTypeAction();

        System.out.println("Le type d'activité supprimée : " + activityRemoved);

        activityTypeController.myDataDataStore.save();

        if(activityTypeController.getView().getError() != null){
            System.out.println(activityTypeController.getView().getError());
        }

        System.out.println(Arrays.asList(activityTypeController.factory.getActivityTypeList()));
    }
}
