/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongo.modele;

/**
 *
 * @author Misaina
 */
public class SuggestProduit extends MongoModele{
    private Integer id;
    private Integer idNotif;
    private Integer vu;
    private Integer idProduit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdNotif() {
        return idNotif;
    }

    public void setIdNotif(Integer idNotif) {
        this.idNotif = idNotif;
    }

    public Integer getVu() {
        return vu;
    }

    public void setVu(Integer vu) {
        this.vu = vu;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }
    
    
            
            
}
