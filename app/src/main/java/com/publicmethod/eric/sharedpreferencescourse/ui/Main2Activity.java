package com.publicmethod.eric.sharedpreferencescourse.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.publicmethod.eric.sharedpreferencescourse.R;
import com.publicmethod.eric.sharedpreferencescourse.adapters.ScoreCardAdapter;
import com.publicmethod.eric.sharedpreferencescourse.models.Hole;

public class Main2Activity extends AppCompatActivity {

    private static final String PREFS_FILE = "com.publicmethod.eric.sharedpreferencescourse.preferences";
    private static final String KEY_STOKE_COUNT = "key_stroke_count";


    private Hole[] mHoles = new Hole[18];

    private RecyclerView mRecyclerView;
    ScoreCardAdapter mScoreCardAdapter;

    private static SharedPreferences mSharedPreferences;
    private static SharedPreferences.Editor mEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        for (int i = 0; i < mHoles.length; i++) {
            int strokes = mSharedPreferences.getInt(KEY_STOKE_COUNT + i, 0);
            mHoles[i] = new Hole("Hole " + (i + 1) + " :", strokes);

        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mScoreCardAdapter = new ScoreCardAdapter(mHoles);
        mRecyclerView.setAdapter(mScoreCardAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setHasFixedSize(true);


    }

    /**
     * Clear the stroke count of all holes and resets the shared preferences.
     */
    private void clearStrokeCounts() {

        for (Hole hole : mHoles) {

            hole.setStrokeCount(0);

        }

        mEditor.clear().apply();
        mScoreCardAdapter.notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main2, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.action_clear_strokes:
                clearStrokeCounts();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        for (int i = 0; i < mHoles.length; i++) {

            mEditor.putInt(KEY_STOKE_COUNT + i, mHoles[i].getStrokeCount());

        }

        mEditor.apply();
    }
}