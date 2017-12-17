package com.itla.mudat.Entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Miguel Peralta on 11/18/2017.
 */

public class Banner implements Serializable {
    private int id;
    private Category category;
    private User user;
    private Date date;
    private int condition;
    private double price;
    private String title;
    private int location;
    private String details;

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public User getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public int getCondition() {
        return condition;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public int getLocation() {
        return location;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", category=" + category +
                ", user=" + user +
                ", date=" + date +
                ", condition=" + condition +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", location=" + location +
                ", details='" + details + '\'' +
                '}';
    }
}
