package com.example.application.account;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DisplayData extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);
        TextView textView = (TextView) findViewById(R.id.pname);
        getSupportActionBar().setTitle("DETAIL OF TRANSACTION");

        DatabaseHandler handler = new DatabaseHandler(this, null, null, 1);
        ListView listView = (ListView) findViewById(R.id.view);

        SharedPreferences sharedPreferences=getSharedPreferences("pname", Context.MODE_PRIVATE);



           if(sharedPreferences.getString("mmb","").equals("CLIENT 1")){
            textView.setText("CLIENT 1");
            CursorAdapter cursorAdapter = new Custom_cursor_adapter(this, handler.getAllData("CLIENT 1"), 0);
            listView.setAdapter(cursorAdapter);}
            else if(sharedPreferences.getString("mmb","").equals("CLIENT 2")){
               textView.setText("CLIENT 2");
               CursorAdapter cursorAdapter = new Custom_cursor_adapter(this, handler.getAllData("CLIENT 2"), 0);
               listView.setAdapter(cursorAdapter);}
           else if(sharedPreferences.getString("mmb","").equals("CLIENT 3")){
               textView.setText("CLIENT 3");
               CursorAdapter cursorAdapter = new Custom_cursor_adapter(this, handler.getAllData("CLIENT 3"), 0);
               listView.setAdapter(cursorAdapter);}
           else if(sharedPreferences.getString("mmb","").equals("CLIENT 4")){
               textView.setText("CLIENT 4");
               CursorAdapter cursorAdapter = new Custom_cursor_adapter(this, handler.getAllData("CLIENT 4"), 0);
               listView.setAdapter(cursorAdapter);}
           else if(sharedPreferences.getString("mmb","").equals("CLIENT 5")){
               textView.setText("CLIENT 5");
               CursorAdapter cursorAdapter = new Custom_cursor_adapter(this, handler.getAllData("CLIENT 5"), 0);
               listView.setAdapter(cursorAdapter);}
           else if(sharedPreferences.getString("mmb","").equals("TOTAL")){
               textView.setText("TOTAL");
               CursorAdapter cursorAdapter = new Custom_cursor_adapter(this, handler.getAllData1(), 0);
               listView.setAdapter(cursorAdapter);}











    }}





