package com.example.smartgarden;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ModeActivity extends AppCompatActivity {

    private DatabaseReference ModeFirebaseDatabase;
    private FirebaseDatabase ModeFirebaseInstance;

    private TextView mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        mode = (TextView) findViewById(R.id.status_alat);
        // mode control
        ModeFirebaseInstance = FirebaseDatabase.getInstance();
        ModeFirebaseDatabase = ModeFirebaseInstance.getReference("mode");

        // kondisi mode
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference statusmod = database.getReference("mode");

        statusmod.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int nilai = dataSnapshot.getValue(int.class);
                mode(nilai);
            }

            private void mode(int nilai) {
                if (nilai == 1) {
                    mode.setText("Auto");
                } else {
                    mode.setText("Manual");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void status_auto(View view) {
        ModeFirebaseDatabase.setValue(1);
    }

    public void status_manual(View view) {
        ModeFirebaseDatabase.setValue(0);
    }
}



