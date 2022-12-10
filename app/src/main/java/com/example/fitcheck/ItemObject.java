package com.example.fitcheck;

import org.json.JSONArray;

public class ItemObject {
    private Integer outfit;
    private String itemType;
    private String description;
    private String itemImage;
    private String link;
    //private JSONArray items;

    public Integer getOutfit() {
        return outfit;
    }

    public void setOutfit(Integer outfit) {
        this.outfit = outfit;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ItemObject(Integer outfit, String itemType, String description, String itemImage, String link) {
        this.outfit = outfit;
        this.itemType = itemType;
        this.description = description;
        this.itemImage = itemImage;
        this.link = link;
    }
}
