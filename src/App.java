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
        List<ActivityType> activityList = activityTypeController.addActivityTypeAction();
        System.out.println(Arrays.asList(activityList));

        activityTypeController.myDataDataStore.save();   


        for (ActivityType s : activityTypeController.activityTypeList){
            System.out.println(s);
        }
    }
}
