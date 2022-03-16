package com.dharamveer.mytogglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dharamveer.mytogglebutton.databinding.ActivityHelloBinding;

public class HelloActivity extends AppCompatActivity {
    Bundle extras;
    String text = "";
    ActivityHelloBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHelloBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (savedInstanceState == null) {
            extras = getIntent().getExtras();
            if (extras != null) {
                binding.textView6.setText("Welcome, " + extras.getString("username", ""));
            }
        } else {
            binding.textView6.setText("Welcome, " + (String) savedInstanceState.getSerializable("username"));
        }
    }
}