package com.example.application.account;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText usr;
    EditText pass;

    public String id="a";
   public String pwd="a";

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usr=(EditText)findViewById(R.id.usr);
        pass=(EditText)findViewById(R.id.pass);
        getSupportActionBar().setTitle("LOGIN");

pass.setOnEditorActionListener(new EditText.OnEditorActionListener() {
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if(actionId==EditorInfo.IME_ACTION_DONE){
           onLogin(getCurrentFocus());

            return true;
        }


        return false;
    }
});


    }
 //for menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        SharedPreferences sharedPreferences=getSharedPreferences("name", Context.MODE_PRIVATE);
        String afa=sharedPreferences.getString("susr","");
        String afa1=sharedPreferences.getString("spass","");

        RelativeLayout content_main = (RelativeLayout) findViewById(R.id.activity_main);
        Intent  i=new Intent(this,Main2Activity.class);;
        Intent j=new Intent(this,Main4Activity.class);
       if(item.getItemId()== R.id.menu_setting){
           if(afa.equals("")&&afa1.equals("")){

               startActivity(i);
           }

           else  startActivity(j);





       }



           return super.onOptionsItemSelected(item);

    }






    public void onLogin(View view){

        String a=usr.getText().toString();
        String b=pass.getText().toString();



        SharedPreferences sharedPreferences=getSharedPreferences("name", Context.MODE_PRIVATE);
        id=  sharedPreferences.getString("susr","");
        pwd=sharedPreferences.getString("spass","");

       if(usr.getText().toString().equals("")&&pass.getText().toString().equals("")){ Toast.makeText(this, "set up login details in Setting", Toast.LENGTH_LONG).show();}
      else {
           if (a.equals(id) && b.equals(pwd)) {


               Toast.makeText(this, "LOGIN SUCESSFUL", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(this, Main3Activity.class);

               startActivity(intent);
               finishActivity(RESULT_OK);
           } else {
               Toast.makeText(this, "Wrong Password", Toast.LENGTH_LONG).show();
           }

       }
    }


}



