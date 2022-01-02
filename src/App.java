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

        if(activityTypeController.getView().getError() != null){
            System.out.println(activityTypeController.getView().getError());
        }
        
        if(activityTypeController.getView().getInformation() != null){
            System.out.println(activityTypeController.getView().getInformation());
        }

        System.out.println(Arrays.asList(activityTypeController.factory.getActivityTypeList()));

        activityTypeController.updateActivityTypeAction();

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

        activityTypeController.myDataDataStore.save();

        System.out.println(Arrays.asList(activityTypeController.factory.getActivityTypeList()));
    }
}
