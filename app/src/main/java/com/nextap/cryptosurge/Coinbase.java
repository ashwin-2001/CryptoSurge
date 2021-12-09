package com.nextap.cryptosurge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Coinbase extends Activity {

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
                startActivity(intent);
                finish();
            }
        });
    }
}