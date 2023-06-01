package com.jawla.ecom;

import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class FeedbackActivity extends AppCompatActivity {


    EditText namedata,emaildata,messagedata,phonedata;
    Button buttonSend, buttonViewDetails;
    Firebase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_feedback);



        namedata = findViewById(R.id.textView);
        emaildata = findViewById(R.id.textView2);
        messagedata = findViewById(R.id.textView3);
        phonedata = findViewById(R.id.textView4);


        buttonSend = findViewById(R.id.buttonsend);
        buttonViewDetails = findViewById(R.id.buttondetails);
        Firebase.setAndroidContext(this);

        String UniqueID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        firebase = new Firebase("https://ecommerce-da452.firebaseio.com/Users" + UniqueID);


        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 buttonViewDetails.setEnabled(true);
                final String name = namedata.getText().toString();
                final String email = emaildata.getText().toString();
                final String message = messagedata.getText().toString();
                final String phone = phonedata.getText().toString();
////////
                    final DatabaseReference RootRef;
                    RootRef = FirebaseDatabase.getInstance().getReference();

                    RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (!(dataSnapshot.child("Feedback").child(name).exists())) {

                                HashMap<String, Object> userdataMap = new HashMap<>();
                                userdataMap.put("Name", name);
                                userdataMap.put("Email", email);
                                userdataMap.put("Message", message);
                                userdataMap.put("Phone", phone);


                                RootRef.child("Feedback").child(name).updateChildren(userdataMap)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Toast.makeText(FeedbackActivity.this, "Feedback Submitted. 😊", Toast.LENGTH_SHORT).show();

                                                }
                                            }
                                        });

                                }
                            }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                ///////////

                Firebase child_name = firebase.child("Name");
                child_name.setValue(name);
                if (name.isEmpty()){
                    namedata.setError("This is an Required Field!");
                    buttonSend.setEnabled(false);

                }else
                {
                    namedata.setError(null);
                    buttonSend.setEnabled(true);
                }


                Firebase child_email = firebase.child("Email");
                child_email.setValue(email);
                if (email.isEmpty()){
                    emaildata.setError("This is an Required Field!");
                    buttonSend.setEnabled(false);

                }else
                {
                    emaildata.setError(null);
                    buttonSend.setEnabled(true);
                }


                Firebase child_message = firebase.child("Message");
                child_message.setValue(message);
                if (message.isEmpty()){
                    messagedata.setError("This is an Required Field!");
                    buttonSend.setEnabled(false);

                }else
                {
                    messagedata.setError(null);
                    buttonSend.setEnabled(true);
                }

                Firebase child_phone = firebase.child("Phone");
                child_phone.setValue(phone);
                if (phone.isEmpty()){
                    phonedata.setError("This is an Required Field!");
                    buttonSend.setEnabled(false);

                }else
                {
                    phonedata.setError(null);
                    buttonSend.setEnabled(true);
                }

                Toast.makeText(FeedbackActivity.this, "Thanks For Feedback! 😊.", Toast.LENGTH_SHORT).show();


                buttonViewDetails.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new AlertDialog.Builder(FeedbackActivity.this)
                                .setTitle("Sended Details")
                                .setMessage("Name - " + name + "\n\nEmail - " + email +  "\n\nMessage - " + message + "\n\nPhone - " + phone)
                                .show();
                    }
                });


            }
        });
    }
}
