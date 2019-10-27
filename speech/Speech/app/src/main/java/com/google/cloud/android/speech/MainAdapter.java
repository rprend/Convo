package com.google.cloud.android.speech;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private Convo[] mDataset;
    private RecyclerView mRecyclerView;

    public static class MainViewHolder extends RecyclerView.ViewHolder {

        private ImageView icon;
        private TextView title;
        private TextView description;
        MainViewHolder(View v) {
            super(v);
            icon = (ImageView) v.findViewById(R.id.card_icon);
            title = (TextView) v.findViewById(R.id.card_title);
            description = (TextView) v.findViewById(R.id.card_description);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MainAdapter(Convo[] myDataset, RecyclerView rv) {
        mDataset = myDataset;
        mRecyclerView = rv;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MainAdapter.MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_card_view, parent, false);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = view.getContext();
                int itemPosition = mRecyclerView.getChildLayoutPosition(view);
                Convo item = mDataset[itemPosition];

                Intent intent = new Intent(context, ConvoActivity.class);
                intent.putExtra("convos", item.convos);
                intent.putExtra("convoID", item.convoID);
                context.startActivity(intent);
            }
        });
        MainViewHolder vh = new MainViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.title.setText(mDataset[position].title);
        holder.description.setText(mDataset[position].description);
        holder.icon.setImageResource(mDataset[position].drawable);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

}
