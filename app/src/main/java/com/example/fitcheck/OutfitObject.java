package com.example.fitcheck;

import org.json.JSONArray;

import java.util.ArrayList;

public class OutfitObject {
    private Integer id;
    private String creator;
    private JSONArray filters;
    private String image;
    //private JSONArray items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public JSONArray getFilters() {
        return filters;
    }

    public void setFilters(JSONArray filters) {
        this.filters = filters;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public OutfitObject(Integer id, String creator, JSONArray filters, String image) {
        this.id = id;
        this.creator = creator;
        this.filters = filters;
        this.image = image;
    }
}
