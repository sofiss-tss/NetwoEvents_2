package com.example.netwoevents;

public class Item {
    int image;
    String names;


    public Item(int image, String names) {
        this.image = image;
        this.names = names;
    }

    public String getText() {
        return names;
    }

    public int getImage() {
        return image;
    }

}
