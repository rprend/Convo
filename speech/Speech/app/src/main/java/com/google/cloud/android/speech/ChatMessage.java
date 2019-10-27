package com.google.cloud.android.speech;

public class ChatMessage {

    private boolean isUser;
    private String message;
    private int id;

    public ChatMessage(String message, boolean isUser, int id) {
        this.message = message;
        this.isUser = isUser;
        this.id = id;

    }

    public int getId() {
        return this.id;
    }

    public boolean isUser() {
        return isUser;
    }

    public String getMessage() {
        return message;
    }

}

