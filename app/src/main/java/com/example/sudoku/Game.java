package com.example.sudoku;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Game extends Activity {
    public static final String TAG = "Soduko";
    public static final int DIFFICULTY_EASY = 0;

    private int puzzle[];
    private int flag[];

    private final static String easyPuzzle = "000010000";

    private PuzzleView puzzleView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        puzzleView = getPuzzle();
        flag = getPuzzle();
        calculateUsedTiles();
        puzzleView = new PuzzleView(this);
        setContentView(puzzleView);
        puzzleView.requestFocus();

    }

}
