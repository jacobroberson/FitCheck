package com.example.fitcheck;

public class ItemObject {
    private String itemType;
    private String description;
    private String link;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ItemObject(String itemType, String description, String link) {
        this.itemType = itemType;
        this.description = description;
        this.link = link;
    }
}
