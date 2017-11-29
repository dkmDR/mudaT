package com.itla.mudat.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Miguel Peralta on 11/25/2017.
 */

public class DbConnection extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "db.db";
    public static String LOG_T = "DbConnection";

    public DbConnection(Context context ) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i(LOG_T, "Starting onCreate....");

        sqLiteDatabase.execSQL(SqlHelperSchema.DROP_USER_TABLE);
        sqLiteDatabase.execSQL(SqlHelperSchema.USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}