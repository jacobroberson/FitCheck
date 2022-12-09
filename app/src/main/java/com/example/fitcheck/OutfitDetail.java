package com.example.fitcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class OutfitDetail extends AppCompatActivity {
    private ImageView mImageView, mItemImage;
    private TextView mDescription, mItemName;
    private int mPosition;
    private DataSource mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outfit_detail);

        Intent i = getIntent();
        mPosition = i.getIntExtra("position", 0);

        mDataSource = new DataSource();
        mImageView = findViewById(R.id.image);
        mDescription = findViewById(R.id.description);
        mItemName = findViewById(R.id.itemName);
        mItemImage = findViewById(R.id.itemImage);
        mImageView.setImageResource(mDataSource.getmPhotoHdPool().get(mPosition));
        mItemImage.setImageResource(mDataSource.getmImagePool().get(mPosition));

        mDescription.setText(getResources().getString(mDataSource.getmDescriptionPool().get(mPosition)));
        mItemName.setText(getResources().getString(mDataSource.getmNamePool().get(mPosition)));
    }
}