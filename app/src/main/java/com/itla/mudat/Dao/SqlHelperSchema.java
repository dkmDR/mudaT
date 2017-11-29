package com.itla.mudat.Dao;

/**
 * Created by Miguel Peralta on 11/25/2017.
 */

public class SqlHelperSchema {

    public static String DROP_USER_TABLE = "DROP TABLE IF EXISTS user";
    public static String USER_TABLE = "CREATE TABLE IF NOT EXISTS user ( `user_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `user_name` TEXT NOT NULL, `user_type` TEXT NOT NULL, `user_identity` TEXT NOT NULL, `user_email` TEXT NOT NULL, `user_phone` TEXT NOT NULL, `user_password` TEXT NOT NULL, `user_status` INTEGER NOT NULL DEFAULT 1 )";

}
