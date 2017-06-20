package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Misaina
 * @version 1.0
 * @created 26-mai-2017 18:53:11
 */
@Entity
public class SuperAdmin extends Utilisateur implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String noAdmin;

    public SuperAdmin() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoAdmin() {
        return noAdmin;
    }

    public void setNoAdmin(String noAdmin) {
        this.noAdmin = noAdmin;
    }

}//end SuperAdmin
