package mongo.modele;

/**
 * @author Misaina
 * @version 1.0
 * @created 26-mai-2017 18:53:12
 */
public class Magasin {

    private Integer nbVues;
    private String logo;
    private String nom;

    public Magasin() {

    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNbVues() {
        return nbVues;
    }

    public void setNbVues(Integer nbVues) {
        this.nbVues = nbVues;
    }

}//end Magasin
