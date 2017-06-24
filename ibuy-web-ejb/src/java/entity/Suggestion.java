/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Misaina
 */
@Entity
public class Suggestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Client clientQuiSuggere;
    private Client clientSuggere;
    private Produit produit;
    private Date daty;
    private Integer vu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClientQuiSuggere() {
        return clientQuiSuggere;
    }

    public void setClientQuiSuggere(Client clientQuiSuggere) {
        this.clientQuiSuggere = clientQuiSuggere;
    }

    public Client getClientSuggere() {
        return clientSuggere;
    }

    public void setClientSuggere(Client clientSuggere) {
        this.clientSuggere = clientSuggere;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Date getDaty() {
        return daty;
    }

    public void setDaty(Date daty) {
        this.daty = daty;
    }

    public Integer getVu() {
        return vu;
    }

    public void setVu(Integer vu) {
        this.vu = vu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suggestion)) {
            return false;
        }
        Suggestion other = (Suggestion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Suggestion[ id=" + id + " ]";
    }

}
