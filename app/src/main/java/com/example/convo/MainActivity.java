package com.example.convo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    }
}
