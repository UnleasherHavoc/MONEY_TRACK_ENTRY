package com.example.application.account;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Total extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);

        String Names[]={"CLIENT 1","CLIENT 2","CLIENT 3","CLIENT 4","CLIENT 5","TOTAL"};

        ListAdapter myAdapter =new CustomAdaptor(this,Names);
         ListView mylist =(ListView)findViewById(R.id.mylistview);
        mylist.setAdapter(myAdapter);
        getSupportActionBar().setTitle("Totals");
    try{    mylist.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String f=String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(Total.this,f,Toast.LENGTH_LONG).show();
                    }
                }


        );}catch (java.lang.IllegalStateException e){}
    }
}
