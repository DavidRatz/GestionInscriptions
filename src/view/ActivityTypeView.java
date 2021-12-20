package view;

import java.util.Scanner;

public class ActivityTypeView {
    Scanner sc = new Scanner(System.in);

    public String saisirActivityTypeName() {
        System.out.println("Entrer un nom de type d'activité : ");
        return sc.nextLine();
    }

    public String saisirActivityTypeRegitration() {
        System.out.println("Voulez-vous ajouter ce type d'activité (O/N) : ");
        return sc.nextLine();
    }
}
