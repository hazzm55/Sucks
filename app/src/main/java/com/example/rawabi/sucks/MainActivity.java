package com.example.rawabi.sucks;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= findViewById(R.id.t1);
        intent = new Intent(
                RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,
                Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
// prompt text is shown on screen to tell user what to say
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "text");



    }
    public void on(View view){
        startActivityForResult(intent, 1111);



    }
    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        try {


            ArrayList<String> list = intent.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = list.get(0);
            textView.setText(spokenText);
        }
        catch (Exception e){
            e.printStackTrace();

        }
    }


}
