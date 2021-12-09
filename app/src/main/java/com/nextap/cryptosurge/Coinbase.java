package com.nextap.cryptosurge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Coinbase extends Activity {

    TextView textViewPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coinbase);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Coinbase.this, Wallet.class);
                startActivity(intent);
                finish();
            }
        });

        findViewById(R.id.stack1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Coinbase.this, Currency.class);
                Bundle bundle = getIntent().getExtras();
                String message = bundle.getString("message");

                textViewPrice = findViewById(R.id.textView_priceBtc);
                String price = textViewPrice.getText().toString();
                intent.putExtra("price", price);

                intent.putExtra("coin", "BTC");

                intent.putExtra("message", message);
                startActivity(intent);
                finish();
            }
        });

        findViewById(R.id.stack2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Coinbase.this, Currency.class);
                Bundle bundle = getIntent().getExtras();
                String message = bundle.getString("message");
                intent.putExtra("message", message);

                textViewPrice = findViewById(R.id.textView_priceDoge);
                String price = textViewPrice.getText().toString();
                intent.putExtra("price", price);

                intent.putExtra("coin", "DOGE");

                startActivity(intent);
                finish();
            }
        });


        findViewById(R.id.stack3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Coinbase.this, Currency.class);
                Bundle bundle = getIntent().getExtras();
                String message = bundle.getString("message");
                intent.putExtra("message", message);

                textViewPrice = findViewById(R.id.textView_priceEth);
                String price = textViewPrice.getText().toString();

                intent.putExtra("price", price);

                intent.putExtra("coin", "ETH");

                startActivity(intent);
                finish();
            }
        });

    }
}