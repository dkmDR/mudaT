package com.itla.mudat.Entity;

import java.io.Serializable;

/**
 * Created by Miguel Peralta on 11/18/2017.
 */

public class Category implements Serializable
{
    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
