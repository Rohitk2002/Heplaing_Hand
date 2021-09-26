package com.rohitkashyap.HelpingHand.Common.LoginSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.rohitkashyap.HelpingHand.R;
import com.rohitkashyap.HelpingHand.User.UserChoice;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    TextInputLayout usernames, passwords;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        usernames = findViewById(R.id.enterusername);
        passwords = findViewById(R.id.enterpassword);
        login = findViewById(R.id.loginin);

    }

    public void back1(View view) {
        startActivity(new Intent(getApplicationContext(), UserChoice.class));
    }

}