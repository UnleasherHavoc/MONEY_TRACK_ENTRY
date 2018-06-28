package com.example.application.account;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.application.account.R.id.pass;
import static com.example.application.account.R.id.usr;

//for setting password
public class Main2Activity extends AppCompatActivity {

MainActivity mainActivity ;
    EditText usr1;
    EditText pass1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        usr1=(EditText)findViewById(usr);
        pass1=(EditText)findViewById(pass);
        mainActivity =new MainActivity();

        getSupportActionBar().setTitle("SETUP LOGIN DETAILS");
        pass1.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_DONE){
                    String a=usr1.getText().toString();
                    String b=pass1.getText().toString();

                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("usr",a);
                    intent.putExtra("pass",b);

                    SharedPreferences sharedPreferences=getSharedPreferences("name", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("susr",a);
                    editor.putString("spass",b);
                    editor.apply();



                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"DETAILS CHANGED",Toast.LENGTH_SHORT).show();



                    return true;
                }


                return false;
            }
        });


    }

    public void onSave (View view){
        String a=usr1.getText().toString();
        String b=pass1.getText().toString();




        if(usr1.getText().toString().equals("")&&pass1.getText().toString().equals("")){ Toast.makeText(this, "Enter Details", Toast.LENGTH_LONG).show();}
       else {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("usr", a);
            intent.putExtra("pass", b);

            SharedPreferences sharedPreferences = getSharedPreferences("name", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("susr", a);
            editor.putString("spass", b);
            editor.apply();


            startActivity(intent);
            Toast.makeText(this, "DETAILS CHANGED", Toast.LENGTH_SHORT).show();


        }


    }






}
