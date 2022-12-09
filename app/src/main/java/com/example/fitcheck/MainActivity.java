package com.example.fitcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public class DescriptionAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater mInflator;
        private DataSource mDataSource;

        public DescriptionAdapter(Context c) {
            mContext = c;
            mInflator = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mDataSource = new DataSource();
        }

        @Override
        public int getCount() {
            return mDataSource.getDataSourceLength();
        }

        @Override
        public Object getItem(int position) { return position; }

        @Override
        public long getItemId(int position) { return position; }

        @Override
        public View getView(int position, View convertView, ViewGroup
                parent)
        {
            ImageView thumbnail;
            TextView description;

            if(convertView == null) {
                convertView = mInflator.inflate(R.layout.list_outfit_layout, parent,false);
            }

            thumbnail = convertView.findViewById(R.id.thumb);   thumbnail.setImageResource(mDataSource.getmPhotoPool().get(position));
            description = convertView.findViewById(R.id.text);
            description.setText(mDataSource.getmDescriptionPool().get(position));

            return convertView;
        }

    }
    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mListView = findViewById(R.id.outfits_list);
        mListView.setAdapter(new DescriptionAdapter(this));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView arg0, View arg1, int
                    position, long arg3) {
                Intent i = new Intent(MainActivity.this, OutfitDetail.class);
                i.putExtra("position", position);
                startActivity(i);
            }
        });
    }
}