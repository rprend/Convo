package com.example.convo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class ConvoActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<ChatMessage> messages;
    private ChatListAdapter adapter;
    private boolean isLive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_convo);

        ArrayList<String> convos = savedInstanceState.getStringArrayList("convos");
        isLive = (convos == null);

        messages = new ArrayList<>();

        listView = (ListView) findViewById(R.id.list_view);

        //set ListView adapter first
        adapter = new ChatListAdapter(this, R.layout.user_bubble, messages);
        listView.setAdapter(adapter);


        if (!isLive) {

        }

    }

    private void displayUserBubble(int id, String text) {
        ChatMessage chatMessage = new ChatMessage(text, true, id);

        messages.add(chatMessage);
        adapter.notifyDataSetChanged();
        listView.setSelection(adapter.getCount() - 1); //always scroll to bottom of list view
    }
}