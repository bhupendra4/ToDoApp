package com.tbcmad.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = (EditText) findViewById(R.id.username_login);
        password = (EditText) findViewById(R.id.login_password);
        btnLogin = findViewById(R.id.login_activity_btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(userName.getText().toString().equals("bhupendra") && password.getText().toString().equals("viper")) {
                    SharedPreferences preferences = getApplicationContext().getSharedPreferences("todo pref", 0);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("authentication", true);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if(!userName.getText().toString().equals("username") && password.getText().toString().equals("password"))
                {
                    userName.requestFocus();
                    userName.setError("Username is incorrect!");
                }

                else if(userName.getText().toString().equals("username") && !password.getText().toString().equals("password"))
                {
                        password.requestFocus();
                        password.setError("Password is incorrect!");
                }



                else {
                    userName.requestFocus();
                    userName.setError("Username & Password is incorrect!");
                    password.requestFocus();
                    password.setError("Username & Password is incorrect!");
                    return;
                }
            }
        });
    }
}