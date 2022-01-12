package utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.ActivityHoraire;
import model.ActivityType;
import model.HorairePersonne;
import model.Personne;

public class DataSerialize implements Serializable {
    public List<ActivityType> activityTypeList = new ArrayList<>();
    public List<ActivityHoraire> activityHoraires = new ArrayList<>();
    public List<Personne> listPersonnes = new ArrayList<>();
    public List<HorairePersonne> listHorairePersonnes = new ArrayList<>();
}
