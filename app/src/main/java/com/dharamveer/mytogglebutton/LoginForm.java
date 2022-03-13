package com.dharamveer.mytogglebutton;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class LoginForm extends AppCompatActivity {

    private TextInputLayout txtUsername, txtPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        buttonLogin = findViewById(R.id.btnLogin);
        txtUsername = findViewById(R.id.textInputLayoutUsername);
        txtPassword = findViewById(R.id.textInputLayoutPassword);

        buttonLogin.setOnClickListener(v -> {
            if (txtUsername.getEditText().getText().toString().isEmpty() && txtPassword.getEditText().getText().toString().isEmpty()) {
                txtUsername.setError("Username cannot be empty!!!");
                txtPassword.setError("Password cannot be empty!!!");
            } else if (txtUsername.getEditText().getText().toString().isEmpty() && !txtPassword.getEditText().getText().toString().isEmpty()) {
                txtUsername.setError("Username cannot be empty!!!");
                txtPassword.setError(null);
            } else if (!txtUsername.getEditText().getText().toString().isEmpty() && txtPassword.getEditText().getText().toString().isEmpty()) {
                txtPassword.setError("Password cannot be empty!!!");
                txtUsername.setError(null);
            } else {
                txtUsername.setError(null);
                txtPassword.setError(null);
                Toast.makeText(this, "Login Successful!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}