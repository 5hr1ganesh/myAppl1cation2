package com.dharamveer.mytogglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dharamveer.mytogglebutton.databinding.ActivityDbexampleBinding;
import com.dharamveer.mytogglebutton.db.DatabaseHelper;

public class DBExampleActivity extends AppCompatActivity {

    private ActivityDbexampleBinding binding;

    DatabaseHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDbexampleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mDbHelper = new DatabaseHelper(this);

        binding.buttonAdd.setOnClickListener(v -> {
            String newEntry = binding.editTextPersonName.getText().toString();
            if (newEntry.length() != 0) {
                addDataNewEntry(newEntry);
            } else {
                Toast.makeText(this, "Text-Field cannot be empty!", Toast.LENGTH_SHORT).show();
            }
        });

        binding.buttonView.setOnClickListener(v -> {
            startActivity(new Intent(this, ListDataActivity.class));
        });

    }

    private void addDataNewEntry(String newEntry) {
        boolean insertData = mDbHelper.addData(newEntry);
        if (insertData) {
            Toast.makeText(this, "Data Successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();
        }
    }
}