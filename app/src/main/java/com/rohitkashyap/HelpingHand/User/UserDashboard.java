package com.rohitkashyap.HelpingHand.User;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;

import com.rohitkashyap.HelpingHand.Databases.RetrieveData;
import com.rohitkashyap.HelpingHand.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;

import static com.rohitkashyap.HelpingHand.R.layout.activity_user_dashboard;

public class UserDashboard extends AppCompatActivity {

    Toolbar toolbars;

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    ImageView loginSignUpBtn;
    TextInputLayout textInputLayout0, textInputLayout1, textInputLayout2;
    Button button, button2;
    String searchBy = "", paid = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(activity_user_dashboard);

//        drawerLayout = findViewById(R.id.drawer_layout);
//        navigationView = findViewById(R.id.nav_view);
//        toolbars = findViewById(R.id.toolbar);

        //Navigation Drawer Menu

//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbars, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();

        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        final AutoCompleteTextView autoCompleteTextViews = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextViews);
        textInputLayout0 = findViewById(R.id.textInputLayout);
        textInputLayout1 = findViewById(R.id.textInputLayout2);
        textInputLayout2 = findViewById(R.id.textInputLayout3);
        button = findViewById(R.id.button);
//        button2 = findViewById(R.id.Donation);
        autoCompleteTextView.setThreshold(2);
        autoCompleteTextView.setThreshold(1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, center);
        autoCompleteTextView.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, cost);
        autoCompleteTextViews.setAdapter(adapter1);

        textInputLayout0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoCompleteTextView.showDropDown();
            }
        });

        textInputLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoCompleteTextViews.showDropDown();
            }
        });

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                searchBy = adapter.getItem(position);
            }
        });

        autoCompleteTextViews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                paid = adapter1.getItem(position);
            }
        });

//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                gotoUrl("https://rzp.io/l/XgGycUz");
//
//            }
//        });

    }

    private void gotoUrl(String s) {

        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));

    }

    private static final String[] center = new String[]{"City", "Pin Code", "Name Of The Center"};
    private static final String[] cost = new String[]{"Paid", "Free", "Unknown"};

    public void callShowingResult(View view) {
        Intent i = new Intent(getApplicationContext(), RetrieveData.class);
        i.putExtra("Key", searchBy);
        i.putExtra("Value", textInputLayout1.getEditText().getText().toString());
        i.putExtra("Paid", paid);
        startActivity(i);

    }

}