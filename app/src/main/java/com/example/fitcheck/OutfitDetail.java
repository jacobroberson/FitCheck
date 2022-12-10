package com.example.fitcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
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
import java.util.ArrayList;
import java.util.List;

public class OutfitDetail extends AppCompatActivity {
    private ListView mListView;
    private int mPosition;
    private String url;


    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outfit_detail);

        mListView = findViewById(R.id.items_list);
        new OutfitDetail.AsyncDataClass().execute();
        Intent i = getIntent();
        mPosition = i.getIntExtra("position", 0);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView arg0, View arg1, int
                    position, long arg3) {
                Intent openLinksIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(openLinksIntent);
            }
        });
    }

    private class AsyncDataClass extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            StringBuilder jsonResult = new StringBuilder();

            try {
                InputStream in = new BufferedInputStream(getResources().openRawResource(R.raw.items));

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
            List<ItemObject> parsedObject = returnParsedJsonObject(result);
            CustomAdapter2 jsonCustomAdapter = new CustomAdapter2(OutfitDetail.this, parsedObject);
            mListView.setAdapter(jsonCustomAdapter);
        }
    }
    private List<ItemObject> returnParsedJsonObject(String result) {

        List<ItemObject> jsonObject = new ArrayList<ItemObject>();
        JSONObject resultObject = null;
        JSONArray jsonArray = null;
        ItemObject newItemObject = null; //interior object holder
        ArrayList<String> creators = new ArrayList<>();

        try {
            resultObject = new JSONObject(result);
            System.out.println("Preparsed JSON object " + resultObject.toString());
            // set up json Array to be parsed
            jsonArray = resultObject.optJSONArray("Items");

            System.out.println(jsonArray.length());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonChildNode = null;
            try {
                jsonChildNode = jsonArray.getJSONObject(i);
                //get all data from stream
                Integer itemOutfit = jsonChildNode.getInt("Outfit");
                String itemType = jsonChildNode.getString("ItemType");
                String itemDescription = jsonChildNode.getString("Description");
                String itemImage = jsonChildNode.getString("ItemImage");
                String itemLink = jsonChildNode.getString("Link");
                newItemObject = new ItemObject(itemOutfit, itemType, itemDescription, itemImage, itemLink);
                if (itemOutfit == mPosition) {
                    jsonObject.add(newItemObject);
                    url = itemLink;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return jsonObject;
    }

}