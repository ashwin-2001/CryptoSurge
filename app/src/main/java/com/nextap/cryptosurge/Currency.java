package com.nextap.cryptosurge;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// Currency class
public class Currency extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currency);
        //Button for USD
        Button buttonUSD = (Button) findViewById(R.id.button_USD);
        buttonUSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Currency.this, currencyconversion.class);
                Bundle bundle = getIntent().getExtras();
                String message = bundle.getString("message");

                String price = bundle.getString("price");
                intent.putExtra("price", price);

                intent.putExtra("message", message);
                intent.putExtra("message2", "USD");

                String coin = bundle.getString("coin");
                intent.putExtra("coin", coin);
                startActivity(intent);
            }
        });
        //Button for EUR
        Button buttonEUR = (Button) findViewById(R.id.button_EUR);
        buttonEUR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Currency.this, currencyconversion.class);
                Bundle bundle = getIntent().getExtras();
                String message = bundle.getString("message");

                String price = bundle.getString("price");
                intent.putExtra("price", price);

                intent.putExtra("message", message);
                intent.putExtra("message2", "EUR");

                String coin = bundle.getString("coin");
                intent.putExtra("coin", coin);
                startActivity(intent);
            }
        });
        //Button for GBP
        Button buttonGBP = (Button) findViewById(R.id.button_GBP);
        buttonGBP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Currency.this, currencyconversion.class);
                Bundle bundle = getIntent().getExtras();
                String message = bundle.getString("message");
                intent.putExtra("message", message);
                intent.putExtra("message2", "GBP");

                String price = bundle.getString("price");
                intent.putExtra("price", price);

                String coin = bundle.getString("coin");
                intent.putExtra("coin", coin);

                startActivity(intent);
            }
        });
        //Button for JPY
        Button buttonJPY = (Button) findViewById(R.id.button_JPY);
        buttonJPY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Currency.this, currencyconversion.class);
                Bundle bundle = getIntent().getExtras();
                String message = bundle.getString("message");
                intent.putExtra("message", message);
                intent.putExtra("message2", "JPY");

                String price = bundle.getString("price");
                intent.putExtra("price", price);

                String coin = bundle.getString("coin");
                intent.putExtra("coin", coin);

                startActivity(intent);
            }
        });

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Currency.this, Wallet.class);
                startActivity(intent);
                finish();
            }
        });
    }
}