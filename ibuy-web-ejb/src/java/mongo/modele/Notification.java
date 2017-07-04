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
public class Notification extends MongoModele{
    private Integer id;
    private String lien;
    private String libelle;
    private Integer idClient;
    private Integer vu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getVu() {
        return vu;
    }

    public void setVu(Integer vu) {
        this.vu = vu;
    }
    
    
}
