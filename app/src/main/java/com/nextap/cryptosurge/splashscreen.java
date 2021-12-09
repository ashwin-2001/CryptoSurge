package com.nextap.cryptosurge;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;



public class splashscreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        SQLiteDatabase db = openOrCreateDatabase("login",MODE_PRIVATE,null);
        db.execSQL(
                "create table IF NOT EXISTS users " +
                        "(username text , password text)"
        );

        db.execSQL("insert into users (username,password) values ('admin','1234')");


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(splashscreen.this, Login.class);
                intent.putExtra("message", "WB");
                startActivity(intent);
                finish();
            }
        }, 3000);   //5 seconds
    }
}