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

        messages = new ArrayList<>();
        ArrayList<String> convos = savedInstanceState.getStringArrayList("convos");
        ArrayList<Integer> convoID = savedInstanceState.getIntegerArrayList("convoID");
        isLive = (convos == null);

        //set ListView adapter first
        listView = findViewById(R.id.list_view);
        adapter = new ChatListAdapter(this, R.layout.user_bubble, messages);
        listView.setAdapter(adapter);

        if (!isLive) {
            for (int i = 0; i < convos.size(); i++) {
                displayUserBubble(convoID.get(i), convos.get(i));
            }
        } else {

        }

    }

    private void displayUserBubble(int id, String text) {
        ChatMessage chatMessage = new ChatMessage(text, true, id);

        messages.add(chatMessage);
        adapter.notifyDataSetChanged();
        listView.setSelection(adapter.getCount() - 1); // always scroll to bottom of list view
    }
}