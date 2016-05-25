package entity;

import java.sql.Date;

/**
 * Created by roski on 21.5.16.
 */
public class Order {
    public void setOrderDate(Date date) {
        orderDate = date;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setEventDate(Date date) {
        eventDate = date;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getService() {
        return service;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Date orderDate;
    private Date eventDate;
    private String service;
    private String user;
    private String id;
}
