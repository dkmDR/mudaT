package com.itla.mudat.Models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itla.mudat.Dao.DbConnection;
import com.itla.mudat.Entity.User;
import com.itla.mudat.Entity.UserType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miguel Peralta on 11/25/2017.
 */

public class UserModel {

    private DbConnection con;

    public UserModel( Context context ) {
        this.con = new DbConnection(context);
    }

    /**
     *
     * @param usr
     */
    public void create(User usr) {
        SQLiteDatabase SqlDb = this.con.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("user_name", usr.getName());
        cv.put("user_type", usr.getType().toString());
        cv.put("user_identity", usr.getIdt());
        cv.put("user_email", usr.getEmail());
        cv.put("user_phone", usr.getPhone());
        cv.put("user_password", usr.getPassword());
        cv.put("user_status",1);

        if ( usr.getId() > 0 ) {
            SqlDb.update("user", cv, "user_id =? ", new String[] {String.valueOf(usr.getId())});
        } else {
            SqlDb.insert("user", null, cv);
        }

        SqlDb.close();
    }

    public List<User> search() {

        List<User> usrList = new ArrayList<>();

        SQLiteDatabase SqlDb = this.con.getReadableDatabase();

        String columns[] = new String[] {"user_id","user_name","user_email","user_phone","user_type"};

        Cursor crs = SqlDb.query("user",columns,null,null,null,null,null);

        crs.moveToFirst();

        while ( !crs.isAfterLast() ) {
            User u = new User();
            u.setId(crs.getInt( crs.getColumnIndex("user_id")) );
            u.setName(crs.getString( crs.getColumnIndex("user_name")) );
            u.setEmail(crs.getString( crs.getColumnIndex("user_email")) );
            u.setPhone(crs.getString( crs.getColumnIndex("user_phone")) );
            u.setType(UserType.valueOf( crs.getString( crs.getColumnIndex("user_type") ) ) );

            usrList.add(u);
            crs.moveToNext();
        }

        crs.close();
        SqlDb.close();

        return usrList;
    }

}
