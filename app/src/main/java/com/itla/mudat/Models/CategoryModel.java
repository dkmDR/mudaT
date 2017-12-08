package com.itla.mudat.Models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itla.mudat.Dao.DbConnection;
import com.itla.mudat.Entity.Category;
import com.itla.mudat.Entity.User;
import com.itla.mudat.Entity.UserType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miguel Peralta on 11/29/2017.
 */

public class CategoryModel {

    private DbConnection con;

    public CategoryModel(Context context ) {
        this.con = new DbConnection(context);
    }

    public void create(Category category) {

        SQLiteDatabase SqlDb = this.con.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("category_name", category.getName());

        if ( category.getId() > 0 ) {
            SqlDb.update("categorie", cv, "user_id =? ", new String[] {String.valueOf(category.getId())});
        } else {
            SqlDb.insert("categorie", null, cv);
        }

        SqlDb.close();

    }

    public List<Category> search() {

        List<Category> categoryList = new ArrayList<>();

        SQLiteDatabase SqlDb = this.con.getReadableDatabase();

        String columns[] = new String[] {"category_id","category_name"};

        Cursor crs = SqlDb.query("categorie",columns,null,null,null,null,null);

        crs.moveToFirst();

        while ( !crs.isAfterLast() ) {
            Category c = new Category();
            c.setId(crs.getInt( crs.getColumnIndex("category_id")) );
            c.setName(crs.getString( crs.getColumnIndex("category_name")) );

            categoryList.add(c);
            crs.moveToNext();
        }

        crs.close();
        SqlDb.close();

        return categoryList;
    }

}
