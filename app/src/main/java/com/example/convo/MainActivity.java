package com.example.convo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ConvoActivity.class);
                startActivity(intent);
            }
        });
    }

}
