package com.example.application.account;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by BAIG1995 on 1/12/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="accounts.db";
    private static final String TABLE_NAME="account";
    private static final String COLUMN_ID="_id";
    private static final String COLUMN_NAME="person";
    private static final String COLUMN_AMOUNT="amount";
    private static final String COLUMN_DATE="date";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ACCOUNT_TABLE="CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT , " + COLUMN_NAME + " TEXT,"
                + COLUMN_AMOUNT + " INTEGER,"+ COLUMN_DATE + " TEXT" + ");";
        db.execSQL(CREATE_ACCOUNT_TABLE);
    }


    //to set Date
    public String getDATE(){
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault());
        Date date=new Date();
        return dateFormat.format(date);

    }


@RequiresApi(api = Build.VERSION_CODES.N)
//add data to database
public void addinfo(Account account){
    SQLiteDatabase db=getWritableDatabase();
    ContentValues values=new ContentValues();
    values.put(COLUMN_NAME,account.get_name());
    values.put(COLUMN_AMOUNT,account.get_amount());
    values.put(COLUMN_DATE,getDATE());
    db.insert(TABLE_NAME,null,values);
    db.close();
}

   /* public String getinfo(){
        String name="";
        String amt="";
        String date="";


        SQLiteDatabase db=getReadableDatabase();
        String query ="SElECT" + "*" + "FROM " + TABLE_NAME ;
        Cursor cursor =db.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if(cursor.getString(cursor.getColumnIndex(COLUMN_NAME))!=null) {
                date+= cursor.getString(cursor.getColumnIndex(COLUMN_DATE));

                amt+=cursor.getString(cursor.getColumnIndex(COLUMN_AMOUNT));

               // amt+= cursor.getString(cursor.getColumnIndex(COLUMN_AMOUNT));
               date += "\n";
                name += "\n";
              amt += "\n";
            }
                cursor.moveToNext();
            //amt= cursor.getString(1);
        }

             db.close();
           return (date+"  "+"RS"+" "+amt);

    }*/

//total amount
    public String get_totalamount(){
        String name="";
        String amt="";
        int a=0;

        SQLiteDatabase db=getReadableDatabase();
        String query ="SElECT" + "*" + "FROM " + TABLE_NAME ;
        Cursor cursor =db.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if(cursor.getString(cursor.getColumnIndex(COLUMN_NAME))!=null) {
                name = cursor.getString(cursor.getColumnIndex(COLUMN_AMOUNT));
                a+=Integer.parseInt(name);
                // name += "\n";
            }
            cursor.moveToNext();
            //amt= cursor.getString(1);
        }
        amt=String.valueOf(a);
        db.close();
        return (amt);

    }



//person total sum
    public String get_totalamount1(String a){
        String name="";
        String amt="";
        int a1=0;

        SQLiteDatabase db=getReadableDatabase();

        Cursor cursor =db.rawQuery("SELECT * FROM account where person=?",new String[]{a});
        cursor.moveToFirst();
       while (!cursor.isAfterLast()) {
            if(cursor.getString(cursor.getColumnIndex(COLUMN_ID))!=null) {
                name = cursor.getString(cursor.getColumnIndex(COLUMN_AMOUNT));
                a1+=Integer.parseInt(name);
                // name += "\n";
            }
            cursor.moveToNext();
            //amt= cursor.getString(1);
        }

        amt=String.valueOf(a1);
        db.close();
        return (amt);

    }


//by name
    public Cursor getAllData (String a) {
      SQLiteDatabase db=getReadableDatabase();





        return db.rawQuery("SELECT * FROM account where person=?",new String[]{a});

    }

    //compl. database
    public Cursor getAllData1 () {
        SQLiteDatabase db=getReadableDatabase();

        String as = "SELECT * FROM " + TABLE_NAME;



        return db.rawQuery(as,null);


    }










//to delete via name and amt
    public void deleteproduct(String S,String T){
        SQLiteDatabase db=getWritableDatabase();
        db.delete(TABLE_NAME,COLUMN_NAME+"=? AND "+COLUMN_AMOUNT +"=?",new String[]{S,T});
        //db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME + "=\"" + S + "\" + ;");
         db.close();
    }


    public void deleteproductid(String a){
        SQLiteDatabase db=getWritableDatabase();

        db.delete(TABLE_NAME,COLUMN_ID+"=?",new String[]{a});
        db.close();
    }





    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("DROP TABLE IF ALREADY EXIST"+TABLE_NAME);
        onCreate(db);
    }



}
