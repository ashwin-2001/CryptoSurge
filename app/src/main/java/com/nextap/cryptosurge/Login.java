package com.nextap.cryptosurge;

import android.app.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.editText_username);
        password = findViewById(R.id.editText_password);

        findViewById(R.id.button_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uname = username.getText().toString();
                String pass = password.getText().toString();

                if(uname.length()==0||pass.length()==0){
                    Toast.makeText(getApplicationContext(),"Enter all details",Toast.LENGTH_SHORT).show();
                    return;
                }

                SQLiteDatabase db = openOrCreateDatabase("login",MODE_PRIVATE,null);

                Cursor resultSet = db.rawQuery("select * from users where username='"+uname+"' and password='"+pass+"'",null);

                if(!resultSet.moveToFirst()){
                    Toast.makeText(getApplicationContext(),"Wrong Credentials",Toast.LENGTH_SHORT).show();

                }
                else {

                    Intent intent = new Intent(Login.this, Wallet.class);
                    startActivity(intent);
                    finish();
                }

//                System.out.println("UNAMEEEEE"+uname);
//                System.out.println("PASSSSSSS"+pass);
//
//                if(uname.equals("admin")&&pass.equals("1234")){
//
//                    Intent intent = new Intent(Login.this, Wallet.class);
//                    startActivity(intent);
//                    finish();
//                }
//                else {
//                    Toast.makeText(getApplicationContext(),"Wrong Credentials",Toast.LENGTH_SHORT).show();
//                }

            }
        });

    }
}