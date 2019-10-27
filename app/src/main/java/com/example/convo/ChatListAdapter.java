package com.example.convo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.daasuu.bl.BubbleLayout;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

public class ChatListAdapter extends ArrayAdapter<ChatMessage> {

    private Activity activity;
    private ArrayList<ChatMessage> chatMessages;
    private int[] colors = { R.color.colorGreen, R.color.colorBlue, R.color.colorOrange, R.color.colorPink };
    private int[] pics = { R.drawable.koala_green, R.drawable.bird_blue, R.drawable.elephant_yellow, R.drawable.panda_pink };

    @NonNull
    @Override
    public Context getContext() {
        return super.getContext();
    }

    Context context = getContext();

    public ChatListAdapter(Activity context, int resource, ArrayList<ChatMessage> objects) {
        super(context, resource, objects);
        this.activity =context;
        this.chatMessages = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        int layoutResource; // determined by view type
        ChatMessage chatMessage = getItem(position);

        if (chatMessage.isUser()) {
            layoutResource = R.layout.user_bubble;
        } else {
            layoutResource = R.layout.info_bubble;
        }

        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = inflater.inflate(layoutResource, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        //set message content
        holder.message.setText(chatMessage.getMessage());

        int usrId = chatMessage.getId();
        int ind = usrId % colors.length;

        BubbleLayout bubbleLayout = convertView.findViewById(R.id.bubble);
        bubbleLayout.setBubbleColor(ContextCompat.getColor(context, colors[ind]));
        ImageView imageView = convertView.findViewById(R.id.pic);
        imageView.setImageResource(pics[ind]);

        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        // return the total number of view types. this value should never change
        // at runtime
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        // return a value between 0 and (getViewTypeCount - 1)
        return position % 2;
    }

    static class ViewHolder {
        private TextView message;

        public ViewHolder(View v) {
            message = (TextView)v.findViewById(R.id.text);
        }
    }
}