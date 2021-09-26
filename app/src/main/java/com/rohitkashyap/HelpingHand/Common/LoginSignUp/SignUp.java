package com.rohitkashyap.HelpingHand.Common.LoginSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rohitkashyap.HelpingHand.R;
import com.rohitkashyap.HelpingHand.User.UserChoice;
import com.rohitkashyap.HelpingHand.User.UserPersonal;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    ImageView backBtn;
    Button next, login;
    TextView titleText;
    TextInputLayout fullName, username, email, password;
    FirebaseDatabase firebaseDatabase1;
    DatabaseReference reference1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_btn);
        login = findViewById(R.id.signup_login_btn);
        titleText = findViewById(R.id.signup_title_text);

        fullName = findViewById(R.id.signup_fullname);
        username = findViewById(R.id.signup_username);
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);

    }

    public void back2(View view) {
        Intent intent = new Intent(getApplicationContext(), UserChoice.class);
    }

    public void login1(View view) {
        Intent intent = new Intent(getApplicationContext(), Login.class);
    }

    public void callNextSignupScreen(View view) {

        if (!validateFullName() | !validateUserName() | !validateEmail() | !validatePassword()) {
            return;
        }

        firebaseDatabase1 = FirebaseDatabase.getInstance();
        reference1 = firebaseDatabase1.getReference("UserData");

        String name = fullName.getEditText().getText().toString();
        String usernamee = username.getEditText().getText().toString();
        String emaill = email.getEditText().getText().toString();
        String passwordd = password.getEditText().getText().toString();

        UserPersonal userPersonal = new UserPersonal(name, usernamee, emaill, passwordd);

        reference1.child(usernamee).setValue(userPersonal);
        Toast.makeText(getApplicationContext(), "Great Now You Can Login",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), SignUp2.class);
        startActivity(intent);
        finish();

    }

    private boolean validateFullName() {
        String val = fullName.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            fullName.setError("Can Not Be Empty");
        } else {
            fullName.setError(null);
            fullName.setErrorEnabled(false);
            return true;
        }
        return false;
    }

    private boolean validateUserName() {
        String val = username.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{4,20}\\z";

        if (val.isEmpty()) {
            username.setError("Can Not Be Empty");
        } else if (val.length() > 20) {
            username.setError("Username is too long!");
            return false;
        } else if (!val.matches(checkspaces)) {
            username.setError("No Spaces Are Allowed!");
            return false;
        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
        return false;
    }

    private boolean validateEmail() {
        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            email.setError("Can Not Be Empty");
            return false;
        } else if (!val.matches(checkEmail)) {
            email.setError("Invalid Email");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = password.getEditText().getText().toString().trim();
        String checkPassword = "^" +
                //"(?=.*[0-9])"+
                //"(?=.*[a-Z])"+
                //"(?=.*[A-Z])"+
                "(?=.*[a-zA-Z])" +
                "(?=.*[@#$%^&+=])" +
                "(?=\\S+$)" +
                ".{4,}" +
                "$";

        if (val.isEmpty()) {
            password.setError("Can Not Be Empty");
            return false;
        } else if (!val.matches(checkPassword)) {
            password.setError("Password Must Have 4 Characters, 1 Special Characters!");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    private void storeNewUSerData() {



    }

}