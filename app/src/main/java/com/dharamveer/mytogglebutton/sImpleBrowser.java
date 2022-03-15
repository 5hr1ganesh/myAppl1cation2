package com.dharamveer.mytogglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class sImpleBrowser extends AppCompatActivity {
    Button btn1;
    EditText edt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_browser);
        btn1 =  findViewById(R.id.btn1);
        edt1 =  findViewById(R.id.edt1);
        btn1.setOnClickListener(v -> {
            String url = edt1.getText().toString();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });
    }
}