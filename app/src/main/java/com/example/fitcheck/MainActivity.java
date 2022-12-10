package com.example.fitcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;


    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.outfits_list);
        new AsyncDataClass().execute();

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView arg0, View arg1, int
                    position, long arg3) {
                Intent i = new Intent(MainActivity.this, OutfitDetail.class);
                i.putExtra("position", position+1);
                startActivity(i);
            }
        });
    }

    private class AsyncDataClass extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            StringBuilder jsonResult = new StringBuilder();

            try {
                InputStream in = new BufferedInputStream(getResources().openRawResource(R.raw.outfits));

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonResult.append(line);
                }
                System.out.println("Returned Json object " + jsonResult.toString());

            } catch (Exception e) {
                System.out.println("Err: " + e);
            } finally {
            }
            return jsonResult.toString();
        }
        @Override
        protected void onPreExecute() {  }

        @Override
        protected void onPostExecute(String result) {

            System.out.println("Result on post execute: " + result);
            List<OutfitObject> parsedObject = returnParsedJsonObject(result);
            CustomAdapter jsonCustomAdapter = new CustomAdapter(MainActivity.this, parsedObject);
            mListView.setAdapter(jsonCustomAdapter);
        }
    }
    private List<OutfitObject> returnParsedJsonObject(String result){

        List<OutfitObject> jsonObject = new ArrayList<OutfitObject>();
        JSONObject resultObject = null;
        JSONArray jsonArray = null;
        OutfitObject newOutfitObject = null; //interior object holder
        ArrayList<String> creators = new ArrayList<>();

        try {
            resultObject = new JSONObject(result);
            System.out.println("Preparsed JSON object " + resultObject.toString());
            // set up json Array to be parsed
            jsonArray = resultObject.optJSONArray("Outfits");

            System.out.println(jsonArray.length());
        } catch (JSONException e) { e.printStackTrace(); }
        for(int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonChildNode = null;
            try {
                jsonChildNode = jsonArray.getJSONObject(i);
                //get all data from stream
                Integer outfitID = jsonChildNode.getInt("ID");
                String outfitCreator = jsonChildNode.getString("Creator");
                JSONArray outfitFilters = jsonChildNode.getJSONArray("Filters");
                String outfitImage = jsonChildNode.getString("Image");
                //JSONArray outfitItems = jsonChildNode.getJSONArray("ItemsArray");
                newOutfitObject = new OutfitObject(outfitID, outfitCreator, outfitFilters, outfitImage);
                jsonObject.add(newOutfitObject);
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return jsonObject;
    } //end method
}