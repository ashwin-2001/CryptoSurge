package com.nextap.cryptosurge;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

// Wallet class
public class Wallet extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wallet);
        //Button for ATM near me
        Button buttonATMnearme = (Button) findViewById(R.id.button_atmnearme);
        buttonATMnearme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wallet.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        //ImageView for coinbase
        ImageView imageViewCoinbase = (ImageView) findViewById(R.id.imageView_coinbase);
        imageViewCoinbase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wallet.this, Coinbase.class);
                intent.putExtra("message", "CB");
                startActivity(intent);
            }
        });
        //ImageView for Binance
        ImageView imageViewBinance = (ImageView) findViewById(R.id.imageView_binance);
        imageViewBinance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wallet.this, Coinbase.class);
                intent.putExtra("message", "BN");
                startActivity(intent);
            }
        });
        //ImageView for Ledger
        ImageView imageViewLedger = (ImageView) findViewById(R.id.imageView_ledger);
        imageViewLedger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wallet.this, Coinbase.class);
                intent.putExtra("message", "Led");
                startActivity(intent);
            }
        });
        //ImageView for Nicehash
        ImageView imageViewNicehash = (ImageView) findViewById(R.id.imageView_nicehash);
        imageViewNicehash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wallet.this, Coinbase.class);
                intent.putExtra("message", "NH");
                startActivity(intent);
            }
        });
        //ImageView for Gemini
        ImageView imageViewGemini = (ImageView) findViewById(R.id.imageView_gemini);
        imageViewGemini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wallet.this, Coinbase.class);
                intent.putExtra("message", "GE");
                startActivity(intent);
            }
        });
        //ImageView for Webull
        ImageView imageViewWebull = (ImageView) findViewById(R.id.imageView_webull);
        imageViewWebull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wallet.this, Coinbase.class);
                intent.putExtra("message", "WB");
                startActivity(intent);
            }
        });
    }
}