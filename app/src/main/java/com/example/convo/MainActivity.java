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
        toPassConvos.add("I am a bird. Chirp.");
        toPassConvos.add("I'm an elephant. Honetly not sure what sound I make.");
        toPassConvos.add("I'm a panda. I don't make sound either lmao.");
        toPassConvos.add("I'm a koala. I just eat leaves that literally poison me and sleep all day because I'm too fucking dumb to do anything else");

        ArrayList<Integer> convosID = new ArrayList<>();
        convosID.add(1);
        convosID.add(2);
        convosID.add(3);
        convosID.add(4);

        Convo[] test = {new Convo("Developer Standup with PM",
                "print description",
                R.drawable.anonymous_elephant,
                toPassConvos,
                convosID)};
        RecyclerView.Adapter mAdapter = new MainAdapter(test, recyclerView);
        recyclerView.setAdapter(mAdapter);

        // TODO: reimplement
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                //Intent intent = new Intent(view.getContext(), ConvoActivity.class);
//                //startActivity(intent);
//            }
//        });

        GifView gif = (GifView) findViewById(R.id.audio_input_gif);
        gif.setVisibility(View.VISIBLE);
        gif.setScaleX(2);
        gif.setScaleY(2);

        gif.play();
        gif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Hello World!",Toast.LENGTH_SHORT).show();
            }
        });


    }

}
