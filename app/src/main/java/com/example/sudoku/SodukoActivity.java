package com.example.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;



public class SodukoActivity extends Activity implements OnClickListener {

    private static final String TAG = "Soduko";

    private void startGame(int i){
        Log.d(TAG, "clicked on" + i);
        Intent intent = new Intent(this, Game.class);
    }

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
