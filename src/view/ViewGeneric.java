package view;

import java.util.List;
import java.util.Scanner;

public class ViewGeneric {
    Scanner sc = new Scanner(System.in);

    private String error = null;
    private String information = null;
    
    public String getError() {
        return error;
    }
        
    public void setError(String error) {
         this.error = error;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String askUser(String texte2Display) {
        System.out.println(texte2Display);
        return sc.nextLine();
    }
}
