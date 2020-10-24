package com.example.m0317073.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "menu_makan";
    private static final String col0 = "ID";
    private static final String col1 = "nama";

    public DataBaseHelper(Context context)
    {
        super(context,TABLE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery = "CREATE TABLE makeMenu(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nama_menu TEXT," +
                "tag TEXT," +
                "bahan TEXT," +
                "langkah_masak TEXT," +
                "tersedia TEXT"+ ")";
        db.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE student";
        db.execSQL(sql);
        onCreate(db);

    }
}
