package com.example.convo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class ConvoActivity extends Activity {

    private ListView listView;
    private ArrayList<ChatMessage> messages;
    private ChatListAdapter adapter;
    private boolean isLive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_convo);

        //set ListView adapter first
        listView = (ListView) findViewById(R.id.list_view);
        messages = new ArrayList<>();
        adapter = new ChatListAdapter(this, R.layout.user_bubble, messages);
        listView.setAdapter(adapter);

        Bundle extras = getIntent().getExtras();
        isLive = extras == null;
        if (extras != null) {

            ArrayList<String> convos = extras.getStringArrayList("convos");
            ArrayList<Integer> convoID = extras.getIntegerArrayList("convoID");

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