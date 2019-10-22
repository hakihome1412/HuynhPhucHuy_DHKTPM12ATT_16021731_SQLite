package com.example.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBClasses extends SQLiteOpenHelper {

    public DBClasses(@Nullable Context context) {
        super(context, "SinhVien",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String lenhtaobang = "create table SV (SVid TEXT primary key,SVname TEXT)";
        sqLiteDatabase.execSQL(lenhtaobang);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String lenhkhoitaolaibang = "drop table if exists SV";
        sqLiteDatabase.execSQL(lenhkhoitaolaibang);
        onCreate(sqLiteDatabase);
    }

    public void addSinhVien(SinhVien sv)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("SVid",sv.getId());
        value.put("SVname",sv.getName());

        database.insert("SV",null,value);
        database.close();
    }

    public ArrayList<SinhVien> getALLSinhVien()
    {
        ArrayList<SinhVien> list = new ArrayList<>();
        String query = "select * from SV";

        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(query,null);

        if (cursor.moveToFirst())
        {
            do {
                SinhVien sv = new SinhVien();
                sv.setId(cursor.getString(0));
                sv.setName(cursor.getString(1));

                list.add(sv);
            }while (cursor.moveToNext());
        }

        return  list;
    }

    public  int getCount()
    {
        String query = "select * from SV";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(query,null);

        int count = cursor.getCount();

        return count;
    }
}
