package view;

import java.util.Scanner;

public class ActivityTypeView {
    Scanner sc = new Scanner(System.in);

    private String error = null;
    
    public String getError() {
        return error;
    }
        
    public void setError(String error) {
         this.error = error;
    }

    public String gestionActivityTypeName(String action) {
        System.out.println("Entrer un nom de type d'activité à " + action + " : ");
        return sc.nextLine();
    }

    public String gestionActivityTypeRegitration() {
        System.out.println("Faut-il une inscription pour ce type d'activité  (O/N) : ");
        return sc.nextLine();
    }

    public String gestionActivityTypeName(String action, String newName) {
        System.out.println("Entrer un " + newName + " de type d'activité à " + action + " : ");
        return sc.nextLine();
    }

    public String gestionActivityTypeConfirmation() {
        System.out.println("Voulez-vous supprimer ce type d'activité (O/N) : ");
        return sc.nextLine();
    }

    // public String removeActivityTypeName() {
    //     System.out.println("Entrer un nom de type d'activité à supprimer : ");
    //     return sc.nextLine();
    // }

    // public String removeActivityTypeRegitration() {
    //     System.out.println("Voulez-vous supprimer ce type d'activité (O/N) : ");
    //     return sc.nextLine();
    // }
}
