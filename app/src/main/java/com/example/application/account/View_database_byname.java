package com.example.application.account;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class View_database_byname extends AppCompatActivity {
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_database_byname);
        try {
            getSupportActionBar().setTitle("DETAILS OF CLIENTS");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void mmb(View view){
        SharedPreferences sharedPreferences=getSharedPreferences("pname", Context.MODE_PRIVATE);
        SharedPreferences.Editor  editor=sharedPreferences.edit();
        editor.putString("mmb","CLIENT 1");
        editor.apply();
         i=new Intent(this,DisplayData.class);

        startActivity(i);

    }
    public void mkb(View view){
        SharedPreferences sharedPreferences=getSharedPreferences("pname", Context.MODE_PRIVATE);
        SharedPreferences.Editor  editor=sharedPreferences.edit();
        editor.putString("mmb","CLIENT 2");
        editor.apply();
        i=new Intent(this,DisplayData.class);

        startActivity(i);

    }

    public void mjb(View view){
        SharedPreferences sharedPreferences=getSharedPreferences("pname", Context.MODE_PRIVATE);
        SharedPreferences.Editor  editor=sharedPreferences.edit();
        editor.putString("mmb","CLIENT 3");
        editor.apply();
       i= new Intent(this,DisplayData.class);

        startActivity(i);
    }
    public void mjjb(View view){
        SharedPreferences sharedPreferences=getSharedPreferences("pname", Context.MODE_PRIVATE);
        SharedPreferences.Editor  editor=sharedPreferences.edit();
        editor.putString("mmb","CLIENT 4");
        editor.apply();

         i=new Intent(this,DisplayData.class);

        startActivity(i);

    }
    public void oth(View view){
        SharedPreferences sharedPreferences=getSharedPreferences("pname", Context.MODE_PRIVATE);
        SharedPreferences.Editor  editor=sharedPreferences.edit();
        editor.putString("mmb","CLIENT 5");
        editor.apply();
         i=new Intent(this,DisplayData.class);

        startActivity(i);

    }

    public void tot(View view){
        SharedPreferences sharedPreferences=getSharedPreferences("pname", Context.MODE_PRIVATE);
        SharedPreferences.Editor  editor=sharedPreferences.edit();
        editor.putString("mmb","TOTAL");
        editor.apply();

         i=new Intent(this,DisplayData.class);

        startActivity(i);

    }





}
