package com.mycode.sparkspay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DB_Handler extends SQLiteOpenHelper {
    private String TABLE_NAME = "customers";
    public DB_Handler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + TABLE_NAME + "(sno INTEGER PRIMARY KEY, name TEXT, acNo TEXT, mob TEXT, location TEXT, age INTEGER, gender TEXT)";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop = "DROP TABLE IF EXISTS " + db;
        db.execSQL(drop, new String[]{"customers"});
//        onCreate(db);
    }

    public void addCustomer(Customers emp){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", emp.getName());
        values.put("acNo", emp.getAcNo());
        values.put("mob", emp.getMob());
        values.put("location", emp.getEmail());
        values.put("age", emp.getBalance());
        values.put("gender", emp.getGender());
        db.insert("customers", null, values);
        db.close();
    }

    public List<Customers> getCustomer(){
        List<Customers> allCustomers = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String select = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);
        if(cursor != null && cursor.moveToFirst()){
            do{
                Customers customers = new Customers();
                customers.setSlNo(Integer.parseInt(cursor.getString(0)));
                customers.setName(cursor.getString(1));
                customers.setAcNo(cursor.getString(2));
                customers.setMob(cursor.getString(3));
                customers.setEmail(cursor.getString(4));
                customers.setBalance(Integer.parseInt(cursor.getString(5)));
                customers.setGender(cursor.getString(6));

                allCustomers.add(customers);

            }while (cursor.moveToNext());
        }
        return allCustomers;
    }
}
