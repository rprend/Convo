package com.example.convo;

import android.graphics.drawable.Drawable;

public class Convo {
    public String title;
    public int drawable;
    public String description;

    Convo(String title, String description, int drawable) {
        this.title = title;
        this.description = description;
        this.drawable = drawable;
    }
}
