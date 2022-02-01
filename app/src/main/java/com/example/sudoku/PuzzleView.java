package com.example.sudoku;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

public class PuzzleView extends View {
    public static final String TAG = "Sudoku";
    private int[] flag;
    private final Game game;
    private float width, height;
    private int selX, selY;
    private final Rect selRect = new Rect();

    public PuzzleView(Context context){
        super(context);
        this.game = (Game) context;
        flag = this.game.getPuzzle();
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldW, int oldH){
        width = w / 3f;
        height = h / 3f;

        getRect(selX, selY, selRect);
        Log.d(TAG, "onSizeChanged: width" + width + ", height " + height);
        super.onSizeChanged(w, h , oldW, oldH);
    }


}
