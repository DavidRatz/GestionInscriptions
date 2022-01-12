package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

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
        String error = "";

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
            error += " La date et l'heure de début ne respecte pas le format ! ";
        
        if(birthDate != null && !lastName.isBlank() && !firstName.isBlank() && !street.isBlank() && numberStreet > 0 && !city.isBlank() && postCode > 0 && !country.isBlank() && !phoneNumber.isBlank()) {
            model.setBirthDate(birthDate);
            model.setFirstName(firstName);
            model.setLastName(lastName);
            model.setStreet(street);
            model.setNumberStreet(numberStreet);
            model.setPostCode(postCode);
            model.setCity(city);
            model.setCountry(country);
            model.setPhoneNumber(phoneNumber);

            factory.add(listPersonnes, model);

            view.setInformation("La personne ajoutée : " + model);
        }
        else
            error += " Données incorrectes !";

        if(!error.isBlank())
            view.setError("Erreur : " + error);
    }

    public void updatePersonneAction(){
        view.setError(null);
        view.setInformation(null);
        this.setModel(null);
        String error = "";

        String name2update = view.askUser("Entrer un nom à modifier : ");

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
            error += " La date et l'heure de début ne respecte pas le format ! ";

        Optional<Personne> act = factory.getBy(listPersonnes, p -> p.getLastName().equalsIgnoreCase(name2update));
        if(act.isPresent())
            model = act.get();

        if(model != null){
            if(birthDate != null)
                model.setBirthDate(birthDate);
            else
                error += " Date inchangée !";

            if(!firstName.isBlank())
                model.setFirstName(firstName);
            else
                error += " prénom inchangée !";

            if(!lastName.isBlank())
                model.setLastName(lastName);
            else
                error += " prénom inchangée !";

            if(!street.isBlank())
                model.setStreet(street);
            else
                error += " nom inchangée !";

            if(numberStreet > 0)
                model.setNumberStreet(numberStreet);
            else
                error += " numéro de rue inchangée !";

            if(!city.isBlank())
                model.setCity(city);
            else
                error += " ville inchangée !";

            if(postCode > 0)
                model.setPostCode(postCode);
            else
                error += " code postal inchangée !";

            if(!country.isBlank())
                model.setCountry(country);
            else
                error += " pays inchangée !";

            if(!phoneNumber.isBlank())
                model.setPhoneNumber(phoneNumber);
            else
                error += " numéro de téléphone inchangée !";

            view.setInformation("La personne modifiée : " + model);
        }
        else
            error += " Aucune personne trouvée !";
        
        if(!error.isBlank())
            view.setError("Erreur : " + error);
    }

    public void removePersonneAction(){
        view.setError(null);
        view.setInformation(null);
        this.setModel(null);

        String name2remove = view.askUser("Entrer un nom à modifier : ");

        Optional<Personne> act = factory.getBy(listPersonnes, p -> p.getLastName().equalsIgnoreCase(name2remove));
        if(act.isPresent())
            model = act.get();

        if(model != null)
            view.setInformation("La personne supprimée : " + model);
        else
            view.setError("Erreur : Aucune personne trouvée !");
    }
}
