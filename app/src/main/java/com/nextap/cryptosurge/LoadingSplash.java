package com.nextap.cryptosurge;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class LoadingSplash extends Activity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_splash);

        imageView = findViewById(R.id.imageView_splash);

        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");

        switch(message){
            case "CB":
                imageView.setImageDrawable(getDrawable(R.drawable.coinbase));
                break;
            case "BN":
                imageView.setImageDrawable(getDrawable(R.drawable.binance));
                break;
            case "Led":
                imageView.setImageDrawable(getDrawable(R.drawable.ledger));
                break;
            case "NH":
                imageView.setImageDrawable(getDrawable(R.drawable.nicehash));
                break;
            case "GE":
                imageView.setImageDrawable(getDrawable(R.drawable.gemini));
                break;
            case "WB":
                imageView.setImageDrawable(getDrawable(R.drawable.webull));
                break;
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(LoadingSplash.this, Coinbase.class);
                intent.putExtra("message", message);
                startActivity(intent);
                finish();
            }
        }, 1000);

    }
}