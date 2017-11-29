package com.itla.mudat.Models;

import android.content.Context;

import com.itla.mudat.Dao.DbConnection;

/**
 * Created by Miguel Peralta on 11/29/2017.
 */

public class BannerModel {

    private DbConnection con;

    public BannerModel(Context context ) {
        this.con = new DbConnection(context);
    }
}
