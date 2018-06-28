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

public class Main4Activity extends AppCompatActivity {
EditText editText;
    EditText editText1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        editText=(EditText)findViewById(R.id.editText);
        editText1=(EditText)findViewById(R.id.editText2);
        getSupportActionBar().setTitle("CHANGE ID AND PASSWORD");

        editText1.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_DONE){


                    onCheck(getCurrentFocus());
                    return true;
                }


                return false;
            }
        });
    }



    public void onCheck(View view){
        SharedPreferences sharedPreferences=getSharedPreferences("name", Context.MODE_PRIVATE);
        String ed=sharedPreferences.getString("susr","");
        String ed1=sharedPreferences.getString("spass","");
        Intent i=new Intent(this,Main2Activity.class);
        if(editText.getText().toString().equals(ed)&&editText1.getText().toString().equals(ed1))
        {

            Toast.makeText(this,"CORRECT Password",Toast.LENGTH_SHORT).show();
            startActivity(i);
        }
        else  {

            Toast.makeText(this,"Wrong Password",Toast.LENGTH_SHORT).show();
        }


    }
}
