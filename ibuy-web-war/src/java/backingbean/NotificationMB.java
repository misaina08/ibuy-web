/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbean;

import ejb.NotificationBean;
import ejb.ProduitBean;
import entity.Client;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import mongo.modele.Notification;

/**
 *
 * @author Misaina
 */
@Named(value = "notificationMB")
@RequestScoped
public class NotificationMB {

    @EJB
    private NotificationBean notificationBean;

    @EJB
    private ProduitBean produitBean;

    private List<Notification> notifications;

    /**
     * Creates a new instance of NotificationMB
     */
    public NotificationMB() {
    }

    public List<Notification> getNotifications() {
        FacesContext context = FacesContext.getCurrentInstance();
        Client c = (Client) context.getExternalContext().getSessionMap().get("clientSession");
        if (c != null && notifications == null) {
            Notification notification = new Notification();
            notification.setIdClient(c.getId());
            try {
                notifications = notificationBean.find(notification);
            } catch (Exception ex) {
                Logger.getLogger(NotificationMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

}
