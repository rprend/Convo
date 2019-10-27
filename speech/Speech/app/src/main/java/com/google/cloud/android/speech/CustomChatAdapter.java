package com.google.cloud.android.speech;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomChatAdapter extends RecyclerView.Adapter<CustomChatAdapter.ChatViewHolder>{

    private int[] shapes = { R.drawable.rounded_green, R.drawable.rounded_blue, R.drawable.rounded_orange, R.drawable.rounded_pink};
    private int[] pics = { R.drawable.koala_green, R.drawable.bird_blue, R.drawable.elephant_yellow, R.drawable.panda_pink };

    private ArrayList<ChatMessage> chatMessages = new ArrayList<>();

    void addMessage(ChatMessage message) {

        System.out.println("adding"  + chatMessages.toString());
        chatMessages.add(message);
        notifyDataSetChanged();
    }

    CustomChatAdapter() {
    }
    CustomChatAdapter(ArrayList<String> results) {
        for (int i = 0; i < results.size(); i++) {
            chatMessages.add(new ChatMessage(results.get(i), true, i));
        }
    }


    public ArrayList<String> getMessages() {
        ArrayList<String> to_return = new ArrayList<>();
        for (ChatMessage m : chatMessages) {
            to_return.add(m.getMessage());
        }
        return to_return;
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_bubble, parent, false);

        ChatViewHolder vh = new ChatViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {
        int i = chatMessages.get(position).getId() % shapes.length;
        holder.icon.setImageResource(pics[i]);
        holder.text.setBackground(holder.itemView.getResources().getDrawable(shapes[i], null));

        holder.text.setText(chatMessages.get(position).getMessage());

    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {

        public ImageView icon;
        public TextView text;

        ChatViewHolder(View v) {
            super(v);
            icon = (ImageView) v.findViewById(R.id.pic);
            text = (TextView) v.findViewById(R.id.bubble);
        }
    }

}
