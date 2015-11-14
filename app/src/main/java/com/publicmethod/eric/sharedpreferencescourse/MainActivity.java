package com.publicmethod.eric.sharedpreferencescourse;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_FILE = "com.publicmethod.eric.sharedpreferencescourse.preferences";
    private static final String KEY_EDITTEXT = "key_edittext";

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

        String editText = mSharedPreferences.getString(KEY_EDITTEXT, "");
        mEditText.setText(editText);

    }

    @Override
    protected void onPause() {
        super.onPause();

        mEditor.putString(KEY_EDITTEXT, mEditText.getText().toString());
        mEditor.apply();

    }



}
