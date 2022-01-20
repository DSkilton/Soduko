package com.example.soduko;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity, Activity implements View.OnClickListener {
    private static final String TAG = "Soduko";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View newButton = findViewById(R.id.new_btn);
        newButton.setOnClickListener(this);

        View aboutButton = findViewById(R.id.about_btn);
        aboutButton.setOnClickListener(this);

        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.about_btn:
                Intent i = new Intent(this, About.class);
            startActivity(i);
            break;
        }
    }


}