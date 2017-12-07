package com.itla.mudat.Entity;

import java.io.Serializable;

/**
 * Created by Miguel Peralta on 11/18/2017.
 */

public class User implements Serializable
{

    private int id;
    private String name;
    private UserType type;
    private String idt;
    private String email;
    private String phone;
    private String password;
    private String confirmPassword;
    private Boolean status;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public void setIdt(String idt) {
        this.idt = idt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UserType getType() {
        return type;
    }

    public String getIdt() {
        return idt;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", idt='" + idt + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
