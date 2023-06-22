package com.example.facebooklogin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Fetch_images extends AppCompatActivity {

    // Initializing the ImageView
    ImageView rImage;


    //sdfdghhjgfgfgfadsadsad

    ArrayList<String> mlist=new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_images);

        rImage = findViewById(R.id.rImage);

        FirebaseDatabase firebaseDatabase
                = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference
                = firebaseDatabase.getReference();

        DatabaseReference getImage
                = databaseReference.child("Images/");




        getImage.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                mlist.add(snapshot.getKey());

//                String link=snapshot.child("-NWv26d_mJaAZyE-vwM5").getValue(String.class);
//                Picasso.get().load(link).into(rImage);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        getImage.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(
                            @NonNull DataSnapshot dataSnapshot)
                     {
                         String link=dataSnapshot.child(mlist.get(0)).getValue(String.class);
                         Picasso.get().load(link).into(rImage);
                    }
                    public void onCancelled(
                            @NonNull DatabaseError databaseError)
                    {

                        Toast
                                .makeText(Fetch_images.this,
                                        "Error Loading Image",
                                        Toast.LENGTH_SHORT)
                                .show();
                    }
                });




    }
}

