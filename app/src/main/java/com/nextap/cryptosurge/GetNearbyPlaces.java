package com.nextap.cryptosurge;

import android.os.AsyncTask;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetNearbyPlaces extends AsyncTask<Object,String,String> {


    private GoogleMap mMap;
    String url;
    InputStream is;
    BufferedReader br;
    StringBuilder sb;
    String data;


    @Override
    protected String doInBackground(Object... objects) {
        mMap = (GoogleMap) objects[0];
        url = (String) objects[1];

        try {
            URL myUrl = new URL(url);

            HttpURLConnection httpURLConnection = (HttpURLConnection) myUrl.openConnection();
            httpURLConnection.connect();
            is = httpURLConnection.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));

            sb = new StringBuilder();
            String line = "";

            while((line = br.readLine())!=null){
                sb.append(line);
            }

            data = sb.toString();

            System.out.println("DDDDAAAAAAATTTTTTTTAAAAAAAAAA "+data);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try{
            JSONObject parentObject = new JSONObject(s);
            JSONArray resultsArray = parentObject.getJSONArray("results");

            for(int i=0;i< resultsArray.length();i++){
                JSONObject jsonObject = resultsArray.getJSONObject(i);
                JSONObject locationObj = jsonObject.getJSONObject("geometry").getJSONObject("location");

                String latitude = locationObj.getString("lat");
                String longitude = locationObj.getString("lng");


                String atmName = jsonObject.getString("name");
                String vicinity = jsonObject.getString("vicinity");


                LatLng latLng = new LatLng(Double.parseDouble(latitude),Double.parseDouble(longitude));

                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.title(vicinity);
                markerOptions.position(latLng);

                mMap.addMarker(markerOptions);


            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
