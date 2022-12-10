package com.example.fitcheck;

import static com.facebook.FacebookSdk.getApplicationContext;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private LayoutInflater lInflater;
    private List<OutfitObject> listStorage;

    public CustomAdapter(Context context,
                         List<OutfitObject> customizedListView) {
        lInflater = (LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        listStorage = customizedListView;
    }

    @Override
    public int getCount() {
        return listStorage.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView creator = null;
        ImageView image = null;

        if (convertView == null) {
            convertView = lInflater.inflate(R.layout.list_outfit_layout, parent, false);
        }

        creator = convertView.findViewById(R.id.text);
        creator.setText(listStorage.get(position).getCreator());
        image = convertView.findViewById(R.id.thumb);
        Context c = getApplicationContext();
        image.setImageResource(c.getResources().getIdentifier("drawable/"+listStorage.get(position).getImage(), null, c.getPackageName()));

        return convertView;
    }
}
