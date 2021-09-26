package com.rohitkashyap.HelpingHand.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rohitkashyap.HelpingHand.Admin.ThankYou;
import com.rohitkashyap.HelpingHand.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.razorpay.Checkout;
//import com.razorpay.PaymentResultListener;


public class TakingInfo extends AppCompatActivity {

    TextInputLayout City, POC, PinCode, ContactNum, Addresses, costa, total, Name, Sr;
    Button button5, button6;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taking_info);

        Name = findViewById(R.id.name);
        City = findViewById(R.id.city);
        POC = findViewById(R.id.poc);
        total = findViewById(R.id.capacity);
        ContactNum = findViewById(R.id.contact);
        costa = findViewById(R.id.cost);
        PinCode = findViewById(R.id.pinCode);
        Addresses = findViewById(R.id.address);
        Sr = findViewById(R.id.srnumb);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.Donate);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gotoUrl("https://rzp.io/l/XgGycUz");

            }
        });

    }

    private void gotoUrl(String s) {

        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }

    public void back(View view) {
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
    }

    public void registerButtonclick(View view) {

        String Name_ = Name.getEditText().getText().toString();
        String City_ = City.getEditText().getText().toString();
        String Cap_ = total.getEditText().getText().toString();
        String ContactNum_ = ContactNum.getEditText().getText().toString();
        String Cpsta_ = costa.getEditText().getText().toString();
        String PinCode_ = PinCode.getEditText().getText().toString();
        String Addresses_ = Addresses.getEditText().getText().toString();

        if ((!City_.isEmpty())) {
            City.setError(null);
            City.setErrorEnabled(false);
            if ((!ContactNum_.isEmpty())) {
                ContactNum.setError(null);
                ContactNum.setErrorEnabled(false);
                if ((!Name_.isEmpty())) {
                    Name.setError(null);
                    Name.setErrorEnabled(false);
                    if ((!Addresses_.isEmpty())) {
                        Addresses.setError(null);
                        Addresses.setErrorEnabled(false);

                        firebaseDatabase = FirebaseDatabase.getInstance();
                        reference = firebaseDatabase.getReference("datauser");

                        String Name_a = Name.getEditText().getText().toString();
                        String City_a = City.getEditText().getText().toString();
                        String Poc_a = POC.getEditText().getText().toString();
                        String Cap_a = total.getEditText().getText().toString();
                        String ContactNum_a = ContactNum.getEditText().getText().toString();
                        String Cpsta_a = costa.getEditText().getText().toString();
                        String PinCode_a = PinCode.getEditText().getText().toString();
                        String Addresses_a = Addresses.getEditText().getText().toString();
                        String srnum_a = Sr.getEditText().getText().toString();

                        Details details = new Details(Name_a, City_a, Poc_a, Cap_a, ContactNum_a, Cpsta_a, PinCode_a, Addresses_a,srnum_a);

                        reference.child(srnum_a).setValue(details);

                        Toast.makeText(getApplicationContext(), "Thank You For Your Help", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), ThankYou.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Addresses.setError("Please The Blank Space");
                    }

                } else {
                    PinCode.setError("Please The Blank Space");
                }

            } else {
                ContactNum.setError("Please The Blank Space");
            }

        } else {
            City.setError("Please The Blank Space");
        }

    }
}