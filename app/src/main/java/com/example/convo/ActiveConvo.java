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
    private EditText input;
    private ArrayList<ChatMessage> messages;
    private ChatListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_convo);

        messages = new ArrayList<>();

        listView = (ListView) findViewById(R.id.list_view);
        //input = (EditText) findViewById(R.id.msg_type);

        //set ListView adapter first
        adapter = new ChatListAdapter(this, R.layout.item_out, messages);
        listView.setAdapter(adapter);

        //event for button SEND
        Button btnSend = (Button) findViewById(R.id.btn_chat_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (input.getText().toString().trim().equals("")) {
                    Toast.makeText(ActiveConvo.this, "Please input some text...", Toast.LENGTH_SHORT).show();
                } else {
                    //add message to list

                    System.out.println("adding message");

                    ChatMessage chatMessage = new ChatMessage(input.getText().toString(), isMine());
                    messages.add(chatMessage);
                    adapter.notifyDataSetChanged();
                    listView.setSelection(adapter.getCount() - 1); //always scroll to bottom of list view
                    input.setText("");
                }
            }
        });
    }

    private boolean isMine() {
        Random random = new Random();
        Log.d("Main", "" + random.nextBoolean());
        return random.nextBoolean();
    }
}