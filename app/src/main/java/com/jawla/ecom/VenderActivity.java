 package com.jawla.ecom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

 public class VenderActivity extends AppCompatActivity {



    private final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    private final List<MyItems> myItemslist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender);

        final RecyclerView recyclerView = findViewById(R.id.venderrecycleview);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(VenderActivity.this));

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                myItemslist.clear();

                for (DataSnapshot users : snapshot.child("Users").getChildren()){

                    if (users.hasChild("name") && users.hasChild("phone") && users.hasChild("password"));

                    final String getFullname = users.child("name").getValue(String.class);
                    final String getMobile = users.child("phone").getValue(String.class);
                    final String getEmail = users.child("password").getValue(String.class);

                    MyItems myItems = new MyItems(getFullname, getMobile, getEmail);

                    myItemslist.add(myItems);
                }

                recyclerView.setAdapter(new MyAdapter(myItemslist, VenderActivity.this));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}