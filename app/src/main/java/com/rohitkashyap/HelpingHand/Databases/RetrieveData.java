package com.rohitkashyap.HelpingHand.Databases;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.rohitkashyap.HelpingHand.R;
import com.rohitkashyap.HelpingHand.User.Details;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RetrieveData extends AppCompatActivity {

    List<Details> fetchData;
    RecyclerView recyclerView;
    HelperAdapter helperAdapter;
    DatabaseReference databaseReference;

    Map <String, String> findbymap;
    String Key,Value,Paid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findbymap = new HashMap<>();
        findbymap.put("City","city");
        findbymap.put("Pin Code","pinCode");
        findbymap.put("Name Of The Center","name");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retrieve_data);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent i = getIntent();
        Key = i.getStringExtra("Key");
        Value = i.getStringExtra("Value");
        Paid = i.getStringExtra("Paid");

        fetchData = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("datauser");
        databaseReference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    DataSnapshot snap = task.getResult();
                    if (snap == null) {
                        Log.e("ERROR", "Snap is null");
                        return;
                    }
                    for (DataSnapshot ds : snap.getChildren()) {
                        Details data = ds.getValue(Details.class);
                        if(isSatisfied(data))
                            fetchData.add(data);
                    }
                    helperAdapter = new HelperAdapter(fetchData);
                    recyclerView.setAdapter(helperAdapter);
                } else
                    Log.e("ERROR", task.getException().toString());
            }
        });
    }

    private boolean isSatisfied(Details detail){

        if((detail.cost.equals("") && Paid.equals("Unknown")) || (detail.cost.equals("0") && Paid.equals("Free"))|| (!detail.cost.equals("0") && !detail.cost.equals("") && Paid.equals("Paid")));
        else
            return false;

        if(findbymap.get(Key).equals("name") && detail.name.equals(Value))
            return true;

        else if (findbymap.get(Key).equals("city") && detail.city.equals(Value))
            return true;

        else if(findbymap.get(Key).equals("pinCode") && detail.pincode.equals(Value))
            return true;
        else
            return false;
    }
}