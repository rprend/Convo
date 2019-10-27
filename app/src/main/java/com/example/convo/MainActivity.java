package com.example.convo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

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

        ArrayList<String> toPassConvos = new ArrayList<>();
        toPassConvos.add("Hello, welcome");
        toPassConvos.add("let's get started");
        toPassConvos.add("What, accomplish, last sprint");
        toPassConvos.add("implement several features, in planning doc, fixed, issues");
        toPassConvos.add("Very good work, we'll see you next time");

        ArrayList<Integer> convosID = new ArrayList<>();
        convosID.add(1);
        convosID.add(2);
        convosID.add(1);
        convosID.add(2);
        convosID.add(1);

        ArrayList<String> toPassConvos2 = new ArrayList<>();
        toPassConvos2.add("Thanks for coming, glad many attended");
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

        Convo c1 = new Convo("Developer Standup with PM", "Time: 1:00pm - 1:30pm\nLocation: Conference Room A", R.drawable.code_orange, toPassConvos, convosID);
        Convo c2 = new Convo("Eco Friendly Commitee Meeting", "Topics: Carbon Emissions, Single Use Plastics, etc.", R.drawable.leaf, toPassConvos2, convosID2);
        Convo[] convos = {c1, c2};
        RecyclerView.Adapter mAdapter = new MainAdapter(convos, recyclerView);
        recyclerView.setAdapter(mAdapter);

        GifView gif = (GifView) findViewById(R.id.audio_input_gif);
        gif.setVisibility(View.VISIBLE);
        gif.pause();
        gif.setScaleX((float) 1.50);
        gif.setScaleY((float) 1.50);

        gif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GifView gif = (GifView) findViewById(R.id.audio_input_gif);
                if (gif.isPlaying()) {
                    gif.pause();
                } else {
                    gif.play();
                }

            }
        });


    }

}
