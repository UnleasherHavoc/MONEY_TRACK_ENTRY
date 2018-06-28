package com.example.application.account;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity  {


    EditText amt;
    EditText id;


    DatabaseHandler handler;


    Button button;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

          id=(EditText)findViewById(R.id.editText3);
        amt=(EditText)findViewById(R.id.amt);

        button=(Button)findViewById(R.id.savebutton) ;
         spinner=(Spinner)findViewById(R.id.spinner);
        getSupportActionBar().setTitle("DATABASE MANAGER");


        handler=new DatabaseHandler(this,null,null,1);

        id.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId==EditorInfo.IME_ACTION_GO){

                    deletebyid(getCurrentFocus());

                }


                return false;
            }
        });

        amt.setOnEditorActionListener(
                new EditText.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                                actionId == EditorInfo.IME_ACTION_GO ||
                                event.getAction() == KeyEvent.ACTION_DOWN &&
                                        event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {

                            onshow(getCurrentFocus());
                            return true;
                        }
                        return false;
                    }
                });




    }
//to delete data
    public void delete(View view){String inputText= String.valueOf(spinner.getSelectedItem());
           String string=amt.getText().toString();
        handler.deleteproduct(inputText,amt.getText().toString());
        Toast.makeText(this,"DELETED",Toast.LENGTH_SHORT).show();
        amt.setText("");




    }
    public void deletebyid(View view){
       String id1=id.getText().toString();
        handler.deleteproductid(id1);
        Toast.makeText(this,"DELETED",Toast.LENGTH_SHORT).show();
        id.setText("");




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent  i=new Intent(this,View_database_byname.class);;
      //  RelativeLayout content_main = (RelativeLayout) findViewById(R.id.activity_main);
        if(item.getItemId()== R.id.menu_setting1){
           startActivity(i);

            }
        else if (item.getItemId()==R.id.menu_total){  Intent intent =new Intent(this,Total.class);
            startActivity(intent);
            Toast.makeText(this,"VIEWING TOTAL",Toast.LENGTH_SHORT).show();}

        return super.onOptionsItemSelected(item);

    }


    public void onshow(View view){
        String a=String.valueOf(spinner.getSelectedItem());
        int b= 0;
        try {
            b = Integer.parseInt(amt.getText().toString());
        } catch (NumberFormatException e) {Toast.makeText(getApplicationContext(),"ENTER A NUMBER",Toast.LENGTH_SHORT).show();}

        //if(amt.getText().toString().equals("null")){b=0;}
     if(b!=0){ Account account=new Account(a,b);
        handler.addinfo(account);
       amt.setText("");
        Toast.makeText(this,"ADDED",Toast.LENGTH_SHORT).show();}

    }







}
