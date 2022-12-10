package com.example.fitcheck;

import static com.facebook.FacebookSdk.getApplicationContext;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter2 extends BaseAdapter {

    private LayoutInflater lInflater;
    private List<ItemObject> listStorage;

    public CustomAdapter2(Context context,
                          List<ItemObject> customizedListView) {
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
        TextView description = null;
        ImageView itemImage = null;

        if (convertView == null) {
            convertView = lInflater.inflate(R.layout.list_items_layout, parent, false);
        }

        description = convertView.findViewById(R.id.itemName);
        description.setText(listStorage.get(position).getDescription());
        itemImage = convertView.findViewById(R.id.itemImage);
        Context c = getApplicationContext();
        itemImage.setImageResource(c.getResources().getIdentifier("drawable/"+listStorage.get(position).getItemImage(), null, c.getPackageName()));

        return convertView;
    }

}
