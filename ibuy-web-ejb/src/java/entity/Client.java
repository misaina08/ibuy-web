package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Misaina
 * @version 1.0
 * @created 26-mai-2017 18:53:11 123
 */
@Entity
public class Client extends Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "client")
    private List<Abonnement> abonnements;

    @OneToMany(mappedBy = "client")
    private List<Amitie> amities;

    @OneToMany(mappedBy = "client")
    private List<EvenementClient> evenements;
    private String ref;

    @OneToMany(mappedBy = "client")
    private List<ViewMagasin> vues;
    
    @OneToMany(mappedBy = "clientQuiSuggere")
    private List<Suggestion> suggestion;

    public Client() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Abonnement> getAbonnements() {
        return abonnements;
    }

    public void setAbonnements(List<Abonnement> abonnements) {
        this.abonnements = abonnements;
    }

    public List<Amitie> getAmities() {
        return amities;
    }

    public void setAmities(List<Amitie> amities) {
        this.amities = amities;
    }

    public List<EvenementClient> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<EvenementClient> evenements) {
        this.evenements = evenements;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public List<ViewMagasin> getVues() {
        return vues;
    }

    public void setVues(List<ViewMagasin> vues) {
        this.vues = vues;
    }

    public List<Suggestion> getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(List<Suggestion> suggestion) {
        this.suggestion = suggestion;
    }
    

}//end Client
