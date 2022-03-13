package com.dharamveer.mytogglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ProgressBarActivity extends AppCompatActivity {

    private Button downLoad1, download2;
    private ProgressBar progress1, progress2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        //buttons
        downLoad1= findViewById(R.id.button2);
        download2=findViewById(R.id.button3);

        //progress bar
        progress1= (ProgressBar) findViewById(R.id.progressBar);
        progress2=(ProgressBar) findViewById(R.id.progressBar2);

        progress1.setVisibility(View.INVISIBLE);
        progress2.setVisibility(View.INVISIBLE);

        downLoad1.setOnClickListener(v -> {
            Toast.makeText(this,"Installing from Link 1",Toast.LENGTH_SHORT).show();
            if (progress1.isShown()) {
                progress1.setVisibility(View.INVISIBLE);
            } else {
                progress1.setVisibility(View.VISIBLE);
            }
        });

        download2.setOnClickListener(v -> {
            Toast.makeText(this,"Installing from link 2",Toast.LENGTH_SHORT).show();
            if (progress2.isShown()) {
                progress2.setVisibility(View.INVISIBLE);
            } else {
                progress2.setVisibility(View.VISIBLE);
            }
        });




    }
}