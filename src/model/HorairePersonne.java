package model;

import java.io.Serializable;

public class HorairePersonne implements Serializable {
    private ActivityHoraire activityHoraire;
    private Personne personne;
    public HorairePersonne(ActivityHoraire activityHoraire, Personne personne) {
        this.activityHoraire = activityHoraire;
        this.personne = personne;
    }
    public HorairePersonne() {
    }
    public ActivityHoraire getActivityHoraire() {
        return activityHoraire;
    }
    public void setActivityHoraire(ActivityHoraire activityHoraire) {
        this.activityHoraire = activityHoraire;
    }
    public Personne getPersonne() {
        return personne;
    }
    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
    @Override
    public String toString() {
        return "HorairePersonne [activityHoraire=" + activityHoraire + ", personne=" + personne + "]";
    }    
    
}
