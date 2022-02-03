package com.example.sudoku;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;



public class SodukoActivity extends Activity implements OnClickListener {

    private static final String TAG = "Soduko";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View continueButton = findViewById(R.id.continue_btn);
        continueButton.setOnClickListener(this);

        View newButton = findViewById(R.id.new_btn);
        newButton.setOnClickListener(this);

        View aboutButton = findViewById(R.id.about_btn);
        aboutButton.setOnClickListener(this);

        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);
    }

    public void clickFunction(){
        Log.i("ClickFunction", "Button Pressed");
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.about_btn:
                Intent i = new Intent(this, About.class);
                startActivity(i);
                break;
            case R.id.new_btn:
                openNewGameDialog();
                break;
            case R.id.exit_button:
                Log.d("exit button", "button pressed");
                finish();
                break;
        }
    }

    private void openNewGameDialog(){
        new AlertDialog.Builder(this)
                .setTitle(R.string.new_game_label)
                .setItems(R.array.difficulty, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        startGame(which);
                    }
                })
                .show();
    }

    private void startGame(int i){
        Log.d(TAG, "clicked on" + i);
        Intent intent = new Intent(this, Game.class);
        intent.putExtra(Game.KEY_DIFFICULTY, i);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.settings:
                startActivity(new Intent(this, Prefs.class));
                return true;
        }

        return false;
    }

}
