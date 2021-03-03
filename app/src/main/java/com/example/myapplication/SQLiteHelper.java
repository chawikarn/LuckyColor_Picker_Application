package com.example.myapplication;


import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class SQLiteHelper  extends SQLiteOpenHelper {
    public SQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void  queryData (String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);

    }


    public void  insertData(String name, byte[] image){
        SQLiteDatabase database = getWritableDatabase() ;
        String sql = "INSERT INTO War VALUES (NULL, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,name);

        statement.bindBlob(2,image);

        statement.executeInsert();

    }

    public void deleteData (int id){

        SQLiteDatabase database = getWritableDatabase();
        String sql = "DELETE FROM War WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1,(double)id);

        statement.execute();
        database.close();
    }


    public void updateData(int id,String name, byte[] image  ){
        SQLiteDatabase database = getWritableDatabase() ;

        String sql = "UPDATE War SET name = ?, image = ? WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.bindDouble(1,(double) id);
        statement.bindString(2,name);
        statement.bindBlob(3,image);

        statement.execute();
        database.close();
    }


    public Cursor getData(String sql) {
        SQLiteDatabase database = getReadableDatabase() ;
        return database.rawQuery(sql,null);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}




