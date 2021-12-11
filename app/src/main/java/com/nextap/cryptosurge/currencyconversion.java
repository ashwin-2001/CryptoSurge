package com.nextap.cryptosurge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class currencyconversion extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currencyconversion);

        Button button = (Button) findViewById(R.id.button_conversion);
        Bundle bundle = getIntent().getExtras();
        String message2 = bundle.getString("message2");
        String message = bundle.getString("message");

        String price = bundle.getString("price");
        String coin = bundle.getString("coin");

        EditText from_num = (EditText) findViewById(R.id.from_num);
        TextView from_currency = (TextView) findViewById(R.id.from_currency);
        EditText target_num = (EditText) findViewById(R.id.target_num);
        TextView target_currency = (TextView) findViewById(R.id.target_currency);

        //from_num.setText(price);

        target_currency.setText(message2);
        from_currency.setText(coin);
        Log.e("HERE",message);
        //pop a snackbar when hit convert 1 BTC = 55k USD
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                EditText from_num = (EditText) findViewById(R.id.from_num);
//                TextView target_num = (TextView) findViewById(R.id.target_num);

                String value = from_num.getText().toString();
                String value2 = target_num.getText().toString();
                double result;
                if (!value.equals("")) {
                    switch (message2) {
                        case "USD":
                            result = Double.parseDouble(value) * Integer.parseInt(price);
                            break;
                        case "EUR":
                            result = Double.parseDouble(value) * Integer.parseInt(price);
                            break;
                        case "GBP":
                            result = Double.parseDouble(value) * Integer.parseInt(price);
                            break;
                        case "JPY":
                            result = Double.parseDouble(value) * Integer.parseInt(price);
                            break;
                        default:
                            result = 0;
                    }
                    target_num.setText(String.format("%.4f", result));
                } else {
                    target_num.setText("");
                }
            }
        });

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(currencyconversion.this, Wallet.class);
                startActivity(intent);
                finish();
            }
        });
    }
}