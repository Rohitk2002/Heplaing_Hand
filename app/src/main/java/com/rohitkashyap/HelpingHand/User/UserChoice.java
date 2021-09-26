package com.rohitkashyap.HelpingHand.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rohitkashyap.HelpingHand.R;

public class UserChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_choice);

    }

    public void callLoginScreen1(View view) {

        Toast.makeText(UserChoice.this, "Sorry For Inconvenience", Toast.LENGTH_SHORT).show();

//        Intent intent = new Intent(getApplicationContext(), Login.class);
//
//        Pair[] pairs = new Pair[1];
//
//        pairs[0] = new Pair<View, String>(findViewById(R.id.login_btn), "transition_login");
//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(UserChoice.this, pairs);
//
//            startActivity(intent, options.toBundle());
//        } else {
//            startActivity(intent);
//        }

    }

    public void callSignUpScreen2(View view) {

        Toast.makeText(UserChoice.this, "Sorry For Inconvenience", Toast.LENGTH_SHORT).show();

//        Intent intent = new Intent(getApplicationContext(), SignUp.class);
//
//        Pair[] pairs = new Pair[1];
//
//        pairs[0] = new Pair<View, String>(findViewById(R.id.signup_btn), "transition_signup");
//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(UserChoice.this, pairs);
//
//            startActivity(intent, options.toBundle());
//        } else {
//            startActivity(intent);
//        }

    }

    public void continueLogin(View view) {
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
    }

    public void callLoginScreen11(View view) {
        startActivity(new Intent(getApplicationContext(), TakingInfo.class));
    }

}