package utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.ActivityHoraire;
import model.ActivityType;
import model.Personne;

public class DataSerialize implements Serializable {
    public List<ActivityType> activityTypeList = new ArrayList<>();
    public List<ActivityHoraire> activityHoraires = new ArrayList<>();
    public List<Personne> listPersonnes = new ArrayList<>();
}
