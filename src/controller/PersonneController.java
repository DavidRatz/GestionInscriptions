package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import factory.CRUDGenericFactory;
import model.Personne;
import utils.DataSerialize;
import utils.DataStore;
import view.ViewGeneric;

public class PersonneController {
    private Personne model;
    private ViewGeneric view;
    private CRUDGenericFactory<Personne> factory;
    private List<Personne> listPersonnes;
    
    public PersonneController(Personne model, ViewGeneric view, DataStore<DataSerialize> myDataDataStore) {
        this.model = model;
        this.view = view;
        factory = new CRUDGenericFactory<>();
        listPersonnes = myDataDataStore.getData().listPersonnes;
    }

    public Personne getModel() {
        return model;
    }

    public void setModel(Personne model) {
        this.model = model;
    }

    public ViewGeneric getView() {
        return view;
    }

    public void setView(ViewGeneric view) {
        this.view = view;
    }

    public List<Personne> getListPersonnes() {
        return listPersonnes;
    }

    public void setListPersonnes(List<Personne> listPersonnes) {
        this.listPersonnes = listPersonnes;
    }

    public void addPersonneAction(){
        view.setError(null);
        view.setInformation(null);
        String error = null;

        String lastName = view.askUser("Entrer un nom : ");
        String firstName = view.askUser("Entrer un prénom : ");
        String birthDateText = view.askUser("Entrer une date de naissance (dd/MM/yyyy) : ");
        String street = view.askUser("Entrer une rue : ");
        int numberStreet = Integer.parseInt(view.askUser("Entrer un numéro de rue : "));
        String city = view.askUser("Entrer une ville : ");
        int postCode = Integer.parseInt(view.askUser("Entrer un code postal : "));
        String country = view.askUser("Entrer un pays : ");
        String phoneNumber = view.askUser("Entrer un numéro de téléphone : ");

        LocalDate birthDate = null;

        if(birthDateText.matches("(\\d{2}\\/\\d{2}\\/\\d{2})")){
            birthDate = LocalDate.parse(birthDateText, DateTimeFormatter.ofPattern("dd/MM/yy"));
        }
        else
            error += "La date et l'heure de début ne respecte pas le format ! ";
    }

    public void updatePersonneAction(){

    }

    public void removePersonneAction(){

    }
}
