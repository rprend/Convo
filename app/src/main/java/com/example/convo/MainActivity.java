package com.example.convo;

import androidx.appcompat.app.AppCompatActivity;
import co.intentservice.chatui.ChatView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChatView chatView = (ChatView) findViewById(R.id.chat_view);

    }
}
