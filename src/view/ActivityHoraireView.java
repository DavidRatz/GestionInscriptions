package view;

import java.util.List;

import model.ActivityType;

public class ActivityHoraireView  extends ViewGeneric{
    public String askUserActivityType(String texte2Display, List<ActivityType> listActivityTypes) {
        
        int i = 1;
        System.out.println("Type d'activité : ");
        System.out.println("(0) Aucun");
        for (ActivityType activityType : listActivityTypes) {
            System.out.println("(" + (i++) + ") " + activityType.getName());
        }
        System.out.println(texte2Display);
        //System.out.println(listActivityTypes);
        return sc.nextLine();
    }
}
