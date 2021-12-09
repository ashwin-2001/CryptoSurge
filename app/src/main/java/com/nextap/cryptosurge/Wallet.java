package com.nextap.cryptosurge;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

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

                if(ContextCompat.checkSelfPermission(getApplicationContext(),android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent(Wallet.this, MapsActivity.class);
                    startActivity(intent);
                }
                else{
                    Dexter.withContext(getApplicationContext()).withPermission(android.Manifest.permission.ACCESS_FINE_LOCATION).withListener(new PermissionListener() {
                        @Override
                        public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                            Intent intent = new Intent(Wallet.this, MapsActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                            if(permissionDeniedResponse.isPermanentlyDenied()){
                                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                                builder
                                        .setTitle("Permission Denied")
                                        .setMessage("Location permission is permanently denied. Please allow it from device settings")
                                        .setNegativeButton("Cancel",null)
                                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent intent = new Intent();
                                                intent.setAction(Settings.ACTION_APPLICATION_SETTINGS);
                                                intent.setData(Uri.fromParts("package",getPackageName(),null));
                                            }
                                        })
                                        .show();
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"Permission Denied",Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                            permissionToken.continuePermissionRequest();

                        }
                    }).check();

                }


            }
        });
        //ImageView for coinbase
        ImageView imageViewCoinbase = (ImageView) findViewById(R.id.imageView_coinbase);
        imageViewCoinbase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wallet.this, LoadingSplash.class);
                intent.putExtra("message", "CB");
                startActivity(intent);
            }
        });
        //ImageView for Binance
        ImageView imageViewBinance = (ImageView) findViewById(R.id.imageView_binance);
        imageViewBinance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wallet.this, LoadingSplash.class);
                intent.putExtra("message", "BN");
//                intent.putExtra("imageName", "binance");
                startActivity(intent);
            }
        });
        //ImageView for Ledger
        ImageView imageViewLedger = (ImageView) findViewById(R.id.imageView_ledger);
        imageViewLedger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wallet.this, LoadingSplash.class);
                intent.putExtra("message", "Led");
                startActivity(intent);
            }
        });
        //ImageView for Nicehash
        ImageView imageViewNicehash = (ImageView) findViewById(R.id.imageView_nicehash);
        imageViewNicehash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wallet.this, LoadingSplash.class);
                intent.putExtra("message", "NH");
                startActivity(intent);
            }
        });
        //ImageView for Gemini
        ImageView imageViewGemini = (ImageView) findViewById(R.id.imageView_gemini);
        imageViewGemini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wallet.this, LoadingSplash.class);
                intent.putExtra("message", "GE");
                startActivity(intent);
            }
        });
        //ImageView for Webull
        ImageView imageViewWebull = (ImageView) findViewById(R.id.imageView_webull);
        imageViewWebull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wallet.this, LoadingSplash.class);
                intent.putExtra("message", "WB");
                startActivity(intent);
            }
        });
    }
}