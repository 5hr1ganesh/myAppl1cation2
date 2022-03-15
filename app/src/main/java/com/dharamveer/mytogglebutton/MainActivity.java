package com.dharamveer.mytogglebutton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.dharamveer.mytogglebutton.receiver.MyReceiver;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton1, toggleButton2;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButtonClick();

        }




    private void addListenerOnButtonClick() {
        toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);
        toggleButton2 = (ToggleButton) findViewById(R.id.toggleButton2);
        buttonSubmit = (Button) findViewById(R.id.button);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder result = new StringBuilder();
                result.append("ToggleButton1:").append(toggleButton1.getText());
                result.append("\nToggleButton2:").append((toggleButton2.getText()));
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opt, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginForm.class));
                return true;
            case R.id.item2:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Timepicker.class));
                return true;
            case R.id.item3:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, CalculatorActivity.class));
                return true;
            case R.id.item4:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, BroadcastExample.class));
                return true;
            case R.id.item5:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, CheckBoxActivity.class));
                return true;
            case R.id.item6:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, ProgressBarActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}