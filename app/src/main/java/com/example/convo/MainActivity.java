package com.example.convo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("made it main");

        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.main_activity_recyclerview);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        Convo[] test = {new Convo("Developer Standup with PM",
                "print description",
                R.drawable.anonymous_elephant),
        new Convo("there",
                "saonteusa nsateohu saneou sanoue saneotu haoehu saonetuh sa",
                R.drawable.elephant_pink)};
        mAdapter = new MainAdapter(test);
        recyclerView.setAdapter(mAdapter);

        Button btn = (Button) findViewById(R.id.btn);
    }


    public void gotoActivity(android.view.View v) {
        Intent intent = new Intent(this, ActiveConvo.class);
        startActivity(intent);
    }
}
