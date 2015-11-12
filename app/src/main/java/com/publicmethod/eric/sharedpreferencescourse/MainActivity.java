package com.publicmethod.eric.sharedpreferencescourse;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_FILE = "com.publicmethod.eric.sharedpreferencescourse.preferences";

    private EditText mEditText;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.editText);

        mSharedPreferences = getSharedPreferences(PREFS_FILE, MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();


    }
}
