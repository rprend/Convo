package com.google.cloud.android.speech;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class ConvoActivity extends Activity {

//    private ListView listView;
    private RecyclerView rv;
    private CustomChatAdapter adapter;
    private boolean isLive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_convo);

        //set ListView adapter first
        rv = (RecyclerView) findViewById(R.id.chatview_recycler);
        adapter = new CustomChatAdapter();
        rv.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);

        Bundle extras = getIntent().getExtras();
        isLive = extras == null;

        if (extras != null) {

            ArrayList<String> convos = extras.getStringArrayList("convos");
            ArrayList<Integer> convoID = extras.getIntegerArrayList("convoID");

            for (int i = 0; i < convos.size(); i++) {
                adapter.addMessage(new ChatMessage(convos.get(i), true, convoID.get(i)));
            }

        } else {

        }

//        @Override
//        protected void onPause() {
//            mRecordingSampler.stopRecording();
//            super.onPause();
//        }
//
//        @Override
//        protected void onDestroy() {
//            mRecordingSampler.release();
//            super.onDestroy();
//        }

    }

//    private void displayUserBubble(int id, String text) {
//        ChatMessage chatMessage = new ChatMessage(text, true, id);
//
//        System.out.println("Trying to add " + text);
//
//        messages.add(chatMessage);
//        adapter.notifyDataSetChanged();
////        rv.setSelection(adapter.getCount() - 1); // always scroll to bottom of list view
//    }
}