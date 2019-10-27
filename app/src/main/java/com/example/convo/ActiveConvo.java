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

public class ActiveConvo extends AppCompatActivity {

    private ListView listView;
    private ArrayList<ChatMessage> messages;
    private ChatListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_convo);

        messages = new ArrayList<>();

        listView = (ListView) findViewById(R.id.list_view);

        //set ListView adapter first
        adapter = new ChatListAdapter(this, R.layout.user_bubble, messages);
        listView.setAdapter(adapter);

        // TODO: id = (id_returned_from_api % 4);
        displayUserBubble(0, "I'm text that's in a bubble. I'm text that's in a bubble. I'm text that's in a bubble. I'm text that's in a bubble.");
        displayUserBubble(1, "I am also text in a bubble.");
        displayUserBubble(0, "Fuck off");
        displayUserBubble(1, ":(");
        displayUserBubble(2, "Woah");
        displayUserBubble(4, "Woah1.5");
        displayUserBubble(5, "Woah2");

        //event for button SEND
        //Button btnSend = (Button) findViewById(R.id.btn_chat_send);

//        btnSend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (input.getText().toString().trim().equals("")) {
//                    Toast.makeText(ActiveConvo.this, "Please input some text...", Toast.LENGTH_SHORT).show();
//                } else {
//                    //add message to list
//                    ChatMessage chatMessage = new ChatMessage(input.getText().toString(), isMine());
//                    messages.add(chatMessage);
//                    adapter.notifyDataSetChanged();
//                    listView.setSelection(adapter.getCount() - 1); //always scroll to bottom of list view
//                    //input.setText("");
//                }
//            }
//        });
    }

    private void displayUserBubble(int id, String text) {
        ChatMessage chatMessage = new ChatMessage(text, true, id);

        messages.add(chatMessage);
        adapter.notifyDataSetChanged();
        listView.setSelection(adapter.getCount() - 1); //always scroll to bottom of list view
    }
}