package com.dharamveer.mytogglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.dharamveer.mytogglebutton.receiver.MyReceiver;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton1, toggleButton2;
    private Button buttonSubmit, buttonProgress, buttonCheckBox, buttonBroadcast, buttonLogin, buttonCalculator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButtonClick();

        buttonProgress = (Button) findViewById(R.id.buttonProgressBar);
        buttonCheckBox = (Button) findViewById(R.id.btnCheckBox);
        buttonBroadcast = (Button) findViewById(R.id.btnBroadcast);
        buttonLogin = (Button) findViewById(R.id.btnLogin);
        buttonCalculator = (Button) findViewById(R.id.btnCalculator);

        buttonProgress.setOnClickListener(v -> {
            Toast.makeText(this, "loading", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, ProgressBarActivity.class);
            this.startActivity(i);
        });

        buttonCheckBox.setOnClickListener(v -> {
            Toast.makeText(this, "loading", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, CheckBoxActivity.class);
            this.startActivity(i);
        });

        buttonBroadcast.setOnClickListener(v -> {
            Toast.makeText(this, "loading", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, BroadcastExample.class);
            this.startActivity(i);
        });

        buttonLogin.setOnClickListener(v -> {
            Toast.makeText(this, "loading Form", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, LoginForm.class);
            this.startActivity(i);
        });

        buttonCalculator.setOnClickListener(v -> {
            Toast.makeText(this, "loading Calculator", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, CalculatorActivity.class);
            this.startActivity(i);
        });
    }

    private void addListenerOnButtonClick() {
        toggleButton1=(ToggleButton)findViewById(R.id.toggleButton1);
        toggleButton2=(ToggleButton)findViewById(R.id.toggleButton2);
        buttonSubmit=(Button)findViewById(R.id.button);

        buttonSubmit.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                StringBuilder result=new StringBuilder();
                result.append("ToggleButton1:").append(toggleButton1.getText());
                result.append("\nToggleButton2:").append((toggleButton2.getText()));
                Toast.makeText(getApplicationContext(),result.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}