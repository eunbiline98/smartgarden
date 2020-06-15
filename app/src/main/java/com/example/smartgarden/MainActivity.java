package com.example.smartgarden;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private TextView suhu,rh_udara,rh_tanah,pompa,mode;
    private  Button cntrl_pompa,cntrl_mode,btnConnect,signout;
    private DatabaseReference dataSensor;
    private  EditText addrField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        suhu = (TextView) findViewById(R.id.suhu);
        rh_udara = (TextView) findViewById(R.id.rh_udara);
        rh_tanah = (TextView) findViewById(R.id.rh_tanah);

//        cntrl_pompa = (Button) findViewById(R.id.stPompa);
//        cntrl_mode = (Button) findViewById(R.id.stMode);
        signout = (Button) findViewById(R.id.signout);

        addrField = (EditText) findViewById(R.id.addr);
        btnConnect = (Button) findViewById(R.id.connect);

        pompa = (TextView) findViewById(R.id.keadaan_pompa);
        mode = (TextView) findViewById(R.id.status_alat);

        dataSensor = FirebaseDatabase.getInstance().getReference().child("sensor");
                dataSensor.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot != null) {
                            suhu.setText(dataSnapshot.child("suhu").getValue(String.class));
                            rh_udara.setText(dataSnapshot.child("rh_udara").getValue(String.class));

                            // the same for the last name
                        } else {
                            Toast.makeText(MainActivity.this, "get firebase error", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

        // kondisi soil moisture
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference statusrh = database.getReference("sensor").child("rh_tanah");
        statusrh.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int nilai = dataSnapshot.getValue(int.class);
                sens(nilai);
            }

            private void sens(int nilai) {
                if (nilai == 1) {
                    rh_tanah.setText("Tidak Lembab");
                } else {
                    rh_tanah.setText("Lembab");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // kondisi pompa
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

        // kondisi mode
//        DatabaseReference statusmod = database.getReference("mode");
//        statusmod.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                int nilai = dataSnapshot.getValue(int.class);
//                mode(nilai);
//            }
//
//            private void mode(int nilai) {
//                if (nilai == 1) {
//                    mode.setText("Auto");
//                } else {
//                    mode.setText("Manual");
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        btnConnect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String s = addrField.getEditableText().toString();
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(s));
                startActivity(browserIntent);
            }
        });

//        cntrl_pompa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent control= new Intent(getApplicationContext(),PompaActivity.class);
//                startActivity(control);
//            }
//        });
//
//        cntrl_mode.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent mode= new Intent(getApplicationContext(),ModeActivity.class);
//                startActivity(mode);
//            }
//        });

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
