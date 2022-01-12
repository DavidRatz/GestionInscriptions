package controller;

import java.util.List;

import factory.CRUDGenericFactory;
import model.ActivityHoraire;
import model.ActivityType;
import model.HorairePersonne;
import model.Personne;
import utils.DataSerialize;
import utils.DataStore;
import view.HorairePersonneView;
import view.ViewGeneric;

public class HorairePersonneController {
    private HorairePersonne model;
    private ViewGeneric view = new HorairePersonneView();
    private CRUDGenericFactory<HorairePersonne> factoryHorairePersonne;
    private CRUDGenericFactory<ActivityHoraire> factoryActivityHoraire;
    private CRUDGenericFactory<Personne> factoryPersonne;
    private List<HorairePersonne> lHorairePersonnes;
    private List<ActivityHoraire> listActivityHoraires;
    private List<Personne> listPersonnes;

    public HorairePersonneController(HorairePersonne model, HorairePersonneView view, DataStore<DataSerialize> myDataDataStore) {
        this.model = model;
        this.view = view;
        factoryHorairePersonne = new CRUDGenericFactory<>();
        factoryActivityHoraire = new CRUDGenericFactory<>();
        factoryPersonne = new CRUDGenericFactory<>();
        lHorairePersonnes = myDataDataStore.getData().listHorairePersonnes;
        listActivityHoraires = myDataDataStore.getData().activityHoraires;
        listPersonnes = myDataDataStore.getData().listPersonnes;
    }

    public HorairePersonne getModel() {
        return model;
    }

    public void setModel(HorairePersonne model) {
        this.model = model;
    }

    public ViewGeneric getView() {
        return view;
    }

    public void setView(ViewGeneric view) {
        this.view = view;
    }

    public List<HorairePersonne> getlHorairePersonnes() {
        return lHorairePersonnes;
    }

    public void setlHorairePersonnes(List<HorairePersonne> lHorairePersonnes) {
        this.lHorairePersonnes = lHorairePersonnes;
    }

    public void addHorairePersonneAction(){
        
        int activityHoraireId = Integer.parseInt(((HorairePersonneView) view).askUserActivityHoraire("Entrer le numéro du stage choisi : ", listActivityHoraires))-1;
        int personneId = Integer.parseInt(((HorairePersonneView) view).askUserPersonne("Entrer le numéro de la personne à ajouter au stage choisi : ", listPersonnes))-1;

        ActivityHoraire activityHoraire = factoryActivityHoraire.get(listActivityHoraires,activityHoraireId);
        Personne personne = factoryPersonne.get(listPersonnes,personneId);

        if(activityHoraire != null && personne != null){
            model.setActivityHoraire(activityHoraire);
            model.setPersonne(personne);

            factoryHorairePersonne.add(lHorairePersonnes, model);

            view.setInformation("L'inscription d'une personne à un stage : " + model);
        }
        else
            view.setError("Erreur inscription d'une personne à un stage");        
    }
}
