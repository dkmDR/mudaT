package com.itla.mudat.Models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itla.mudat.Dao.DbConnection;
import com.itla.mudat.Entity.Banner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Miguel Peralta on 11/29/2017.
 */

public class BannerModel {

    private DbConnection con;

    public BannerModel(Context context ) {
        this.con = new DbConnection(context);
    }

    public void create(Banner banner) {

        SQLiteDatabase SqlDb = this.con.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("category_id", banner.getCategory().getId());
        cv.put("user_id", 0);
        cv.put("date", new Date().toString());
        cv.put("condition_id", 0);
        cv.put("price", banner.getPrice());
        cv.put("title", banner.getTitle());
        cv.put("location", 0);
        cv.put("details", banner.getDetails());

        if ( banner.getId() > 0 ) {
//            SqlDb.update("categorie", cv, "category_id =? ", new String[] {String.valueOf(category.getId())});
        } else {
            SqlDb.insert("banner", null, cv);
        }

        SqlDb.close();

    }

    public List<Banner> search() {

        List<Banner> bannerList = new ArrayList<>();

        SQLiteDatabase SqlDb = this.con.getReadableDatabase();

        String columns[] = new String[] {"banner_id","price","title","details"};

        Cursor crs = SqlDb.query("banner",columns,null,null,null,null,null);

        crs.moveToFirst();

        while ( !crs.isAfterLast() ) {
            Banner b = new Banner();
            b.setId(crs.getInt( crs.getColumnIndex("banner_id")) );
            b.setTitle(crs.getString( crs.getColumnIndex("title")) );
            b.setDetails(crs.getString( crs.getColumnIndex("details")) );
            b.setPrice(crs.getDouble( crs.getColumnIndex("price")) );

            bannerList.add(b);
            crs.moveToNext();
        }

        crs.close();
        SqlDb.close();

        return bannerList;
    }

}
