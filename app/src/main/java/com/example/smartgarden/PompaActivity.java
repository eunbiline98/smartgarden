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

public class PompaActivity extends AppCompatActivity {

    private DatabaseReference PompaFirebaseDatabase;
    private FirebaseDatabase PompaFirebaseInstance;

    private TextView pompa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pompa);

        pompa = (TextView) findViewById(R.id.keadaan_pompa);
        // pompa control
        PompaFirebaseInstance = FirebaseDatabase.getInstance();
        PompaFirebaseDatabase = PompaFirebaseInstance.getReference("pompa");

        // kondisi pompa
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference statuspom = database.getReference("status_pompa");

        statuspom.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int nilai = dataSnapshot.getValue(int.class);
                control(nilai);
            }

            private void control(int nilai) {
                if (nilai == 0) {
                    pompa.setText("Aktif");
                } else {
                    pompa.setText("Tidak Aktif");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void pompa_on(View view) {
        PompaFirebaseDatabase.setValue(1);
    }

    public void pompa_off(View view) {
        PompaFirebaseDatabase.setValue(0);
    }
}


