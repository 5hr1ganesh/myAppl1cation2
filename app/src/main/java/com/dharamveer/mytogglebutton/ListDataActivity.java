package com.dharamveer.mytogglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.dharamveer.mytogglebutton.databinding.ActivityListDataBinding;
import com.dharamveer.mytogglebutton.db.DatabaseHelper;

import java.util.ArrayList;

public class ListDataActivity extends AppCompatActivity {

    private static final String TAG = "ListDataActivity";
    DatabaseHelper mDbHelper;

    private ActivityListDataBinding binding;

    ArrayList<String> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityListDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mDbHelper = new DatabaseHelper(this);

        listData = new ArrayList<>();

        populateView();
    }

    private void populateView() {

        Log.d(TAG, "populateView: display data in list view");
        Cursor data = mDbHelper.getData();
        if (data.getCount() == 0) {
            Toast.makeText(this, "No data to show", Toast.LENGTH_SHORT).show();
        } else {
            while (data.moveToNext()) {
                listData.add(data.getString(1));
            }
            ListAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listData);
            binding.lv.setAdapter(adapter);
        }

    }
}