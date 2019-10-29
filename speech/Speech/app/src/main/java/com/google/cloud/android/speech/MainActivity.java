package com.google.cloud.android.speech;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cunoraz.gifview.library.GifView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_main);
        } catch (Exception e) {
        Log.e("onCreateView", "onCreateView", e);
        throw e;
    }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_activity_recyclerview);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        ArrayList<String> toPassConvos1 = new ArrayList<>();
        toPassConvos1.add("Hello");
        toPassConvos1.add("let's get started");
        toPassConvos1.add("accomplish, last sprint");
        toPassConvos1.add("implement several features, planning doc, fixes");
        toPassConvos1.add("Very good work");

        ArrayList<Integer> convosID1 = new ArrayList<>();
        convosID1.add(1);
        convosID1.add(2);
        convosID1.add(1);
        convosID1.add(2);
        convosID1.add(1);

        ArrayList<String> toPassConvos2 = new ArrayList<>();
        toPassConvos2.add("Thanks");
        toPassConvos2.add("concerned, current state of town too many disposable plastics, no viable recycling program");
        toPassConvos2.add("I agree");
        toPassConvos2.add("create, community-wide, recycle initiative");
        toPassConvos2.add("great idea, talk, next meeting");

        ArrayList<Integer> convosID2 = new ArrayList<>();
        convosID2.add(1);
        convosID2.add(2);
        convosID2.add(3);
        convosID2.add(4);
        convosID2.add(2);

        ArrayList<String> toPassConvos3 = new ArrayList<>();
        toPassConvos3.add("How was weekend");
        toPassConvos3.add("good, thanks");
        toPassConvos3.add("looked, documents, sent you");
        toPassConvos3.add("not yet, this weekend, will");
        toPassConvos3.add("let me know, thinking");
        toPassConvos3.add("will do");

        ArrayList<Integer> convosID3 = new ArrayList<>();
        convosID3.add(1);
        convosID3.add(2);
        convosID3.add(1);
        convosID3.add(2);
        convosID3.add(1);
        convosID3.add(2);

        Convo c1 = new Convo("Developer Standup w/ Product Manager", "Time: 1:00pm - 1:30pm\nLocation: Conference Room A", R.drawable.code_orange, toPassConvos1, convosID1);
        Convo c2 = new Convo("Eco-Friendly Committee Meeting", "Topics: Carbon Emissions, Single Use Plastics, etc.", R.drawable.leaf, toPassConvos2, convosID2);
        Convo c3 = new Convo("Office Social", "Date: 12/20/18", R.drawable.cake_blue, toPassConvos3, convosID3);

        Convo[] convos = {c1, c2, c3};
        RecyclerView.Adapter mAdapter = new MainAdapter(convos, recyclerView);
        recyclerView.setAdapter(mAdapter);


        GifView gif = (GifView) findViewById(R.id.audio_input_gif);
        gif.setVisibility(View.VISIBLE);
        gif.play();
        gif.setScaleX((float) 1.35);
        gif.setScaleY((float) 1.35);

        gif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GifView gif = (GifView) findViewById(R.id.audio_input_gif);
                Context context = v.getContext();
                Intent newIntent = new Intent(context, ConvoVoiceActivity.class);
                context.startActivity(newIntent);

            }
        });

    }

}
