package com.google.cloud.android.speech;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//import com.daasuu.bl.BubbleLayout;

public class ChatListAdapter extends ArrayAdapter<ChatMessage> {

    private Activity activity;
    private ArrayList<ChatMessage> chatMessages;
    private int[] shapes = { R.drawable.rounded_green, R.drawable.rounded_blue, R.drawable.rounded_orange, R.drawable.rounded_pink};
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
        int ind = usrId % shapes.length;

        // TODO: implement again
        TextView bubbleLayout = (TextView) convertView.findViewById(R.id.bubble);
        bubbleLayout.setBackground(convertView.getResources().getDrawable(shapes[ind], null));

//        bubbleLayout.setBubbleColor(ContextCompat.getColor(context, colors[ind]));
        ImageView imageView = (ImageView) convertView.findViewById(R.id.pic);
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
            message = (TextView) v.findViewById(R.id.bubble);
        }
    }
}