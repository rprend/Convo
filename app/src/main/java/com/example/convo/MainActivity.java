package com.example.convo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("made it main");

        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn);
    }


    public void gotoActivity(android.view.View v) {
        Intent intent = new Intent(this, ActiveConvo.class);
        startActivity(intent);
    }
}
