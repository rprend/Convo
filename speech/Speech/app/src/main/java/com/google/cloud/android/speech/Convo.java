package com.google.cloud.android.speech;

import java.util.ArrayList;

public class Convo {
    public String title;
    public int drawable;
    public String description;

    public ArrayList<String> convos;
    public ArrayList<Integer> convoID;

    Convo(String title, String description, int drawable, ArrayList<String> convos, ArrayList<Integer> convoID) {
        this.title = title;
        this.description = description;
        this.drawable = drawable;
        this.convos = convos;
        this.convoID = convoID;
    }
}
