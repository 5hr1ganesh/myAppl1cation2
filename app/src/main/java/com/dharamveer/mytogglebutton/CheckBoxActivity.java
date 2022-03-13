package com.dharamveer.mytogglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBox chkJava, chkKotlin;
    private TextView txtResult;
    private Button btnOk, btnCancel;
    private ImageButton imgBtnUndo;

    private ArrayList<String> result = new ArrayList();
    private String var = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        //CheckBoxes
        chkJava = (CheckBox) findViewById(R.id.checkBox);
        chkKotlin = (CheckBox) findViewById(R.id.checkBox2);

        //TextView
        txtResult = (TextView) findViewById(R.id.textView);

        //Button
        btnOk = (Button) findViewById(R.id.button4);
        btnCancel = (Button) findViewById(R.id.button5);

        //ImageButton
        imgBtnUndo = (ImageButton) findViewById(R.id.imageButton);



        txtResult.setText("Please select an option...");

        //checkbox 1
        chkJava.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                result.add(buttonView.getText().toString());
            } else {
                result.remove(buttonView.getText().toString());
            }
        });

        //checkbox2
        chkKotlin.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                result.add(buttonView.getText().toString());
            } else {
                result.remove(buttonView.getText().toString());
            }
        });

        // OK button
        btnOk.setOnClickListener(v -> {
            if (result.isEmpty()) {
                txtResult.setText("Please select an option...");
            } else {
//                txtResult.setText(result.toString());
                for (int i = 0; i <= result.size() - 1; i++) {
                    var += result.get(i) + "\n";
                }

                txtResult.setText(var);
            }
        });

        //Cancel button
        btnCancel.setOnClickListener(v -> {
            finish();
        });

        //Undo button
        imgBtnUndo.setOnClickListener(v -> {
            chkJava.setChecked(false);
            chkKotlin.setChecked(false);
            txtResult.setText("Please select an option...");
        });

    }
}