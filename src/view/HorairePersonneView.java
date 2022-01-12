package view;

import java.util.List;

import model.ActivityHoraire;
import model.Personne;

public class HorairePersonneView extends ViewGeneric {
    public String askUserActivityHoraire(String texte2Display, List<ActivityHoraire> listActivityHoraires) {
        
        int i = 1;
        System.out.println("Activité : ");
        System.out.println("(0) Aucun");
        for (ActivityHoraire activityHoraire : listActivityHoraires) {
            System.out.println("(" + (i++) + ") " + activityHoraire.getName());
        }
        System.out.println(texte2Display);
        //System.out.println(listActivityTypes);
        return sc.nextLine();
    }

    public String askUserPersonne(String texte2Display, List<Personne> listPersonnes) {
        
        int i = 1;
        System.out.println("Personne : ");
        System.out.println("(0) Aucune");
        for (Personne personne : listPersonnes) {
            System.out.println("(" + (i++) + ") " + personne.getFirstName() + " " + personne.getLastName());
        }
        System.out.println(texte2Display);
        //System.out.println(listActivityTypes);
        return sc.nextLine();
    }
}
