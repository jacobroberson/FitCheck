package com.example.fitcheck;

import java.util.ArrayList;

public class DataSource {
    private ArrayList<Integer> mPhotoPool;
    private ArrayList<Integer> mDescriptionPool;
    private ArrayList<Integer> mPhotoHdPool;
    private ArrayList<Integer> mNamePool;
    private ArrayList<Integer> mImagePool;

    public ArrayList<Integer> getmPhotoHdPool() {
        return mPhotoHdPool;
    }

    public ArrayList<Integer> getmPhotoPool() {
        return mPhotoPool;
    }

    public ArrayList<Integer> getmDescriptionPool() { return mDescriptionPool; }

    public ArrayList<Integer> getmNamePool() { return mNamePool; }

    public ArrayList<Integer> getmImagePool() { return mImagePool; }

    private void setupPhotoPool() {
        mPhotoPool.add(R.drawable.outfit_1);
        mPhotoPool.add(R.drawable.outfit_2);
        //mPhotoPool.add(R.drawable.outfit_3);
        //mPhotoPool.add(R.drawable.outfit_4);
        //mPhotoPool.add(R.drawable.outfit_5);
        //mPhotoPool.add(R.drawable.outfit_6);
        //mPhotoPool.add(R.drawable.outfit_7);
        //mPhotoPool.add(R.drawable.outfit_8);
        //mPhotoPool.add(R.drawable.outfit_9);
        //mPhotoPool.add(R.drawable.outfit_10);
    }
    private void setupDescriptionPool() {
        mDescriptionPool.add(R.string.desc_1);
        mDescriptionPool.add(R.string.desc_2);
        //mDescriptionPool.add(R.string.desc_3);
        //mDescriptionPool.add(R.string.desc_4);
        //mDescriptionPool.add(R.string.desc_5);
        //mDescriptionPool.add(R.string.desc_6);
        //mDescriptionPool.add(R.string.desc_7);
        //mDescriptionPool.add(R.string.desc_8);
        //mDescriptionPool.add(R.string.desc_9);
        //mDescriptionPool.add(R.string.desc_10);

    }
    private void setupPhotoHDPool() {
        mPhotoHdPool.add(R.drawable.outfit_hd_1);
        mPhotoHdPool.add(R.drawable.outfit_hd_2);
        //mPhotoHdPool.add(R.drawable.outfit_hd_3);
        //mPhotoHdPool.add(R.drawable.outfit_hd_4);
        //mPhotoHdPool.add(R.drawable.outfit_hd_5);
        //mPhotoHdPool.add(R.drawable.outfit_hd_6);
        //mPhotoHdPool.add(R.drawable.outfit_hd_7);
        //mPhotoHdPool.add(R.drawable.outfit_hd_8);
        //mPhotoHdPool.add(R.drawable.outfit_hd_9);
        //mPhotoHdPool.add(R.drawable.outfit_hd_10);
    }
    private void setupImagePool() {
        mImagePool.add(R.drawable.outfit_1_shirt);
        mImagePool.add(R.drawable.outfit_1_pants);
        mImagePool.add(R.drawable.outfit_1_shoes);
    }
    private void setupNamePool() {
        mNamePool.add(R.string.shirt_1);
        mNamePool.add(R.string.pants_1);
        mNamePool.add(R.string.shoes_1);
    }

    public int getDataSourceLength() {
        return mPhotoPool.size();
    }

    public DataSource() {
        mPhotoPool = new ArrayList();
        mDescriptionPool = new ArrayList();
        mPhotoHdPool = new ArrayList();
        mImagePool = new ArrayList();
        mNamePool = new ArrayList();

        setupPhotoPool();
        setupDescriptionPool();
        setupPhotoHDPool();
        setupImagePool();
        setupNamePool();
    }
}
