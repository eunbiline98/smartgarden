package com.example.smartgarden;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class loginActivity extends AppCompatActivity {
    private Button Btn_login, Btn_register, Btn_reset;
    private EditText Id_login;
    private EditText Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Id_login = (EditText) findViewById(R.id.txt_id);
        Password = (EditText) findViewById(R.id.txt_password);
        Btn_login = (Button) findViewById(R.id.btn_login);

        Btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }

    private void signIn() {
        final String id = Id_login.getText().toString();
        String pass = Password.getText().toString();
        if (TextUtils.isEmpty(id) && TextUtils.isEmpty(pass)) {
            Toast.makeText(loginActivity.this, "Isi ID dan Password", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(id)) {
            Toast.makeText(loginActivity.this, "Isi ID Dahulu", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(pass)) {
            Toast.makeText(loginActivity.this, "Isi Password Dahulu", Toast.LENGTH_SHORT).show();
        } else {
            if (id.equals("16632005") && pass.equals("083831585816")) {
                Intent home = new Intent(loginActivity.this, MainActivity.class);
                startActivity(home);
                Id_login.setText("");
                Password.setText("");

            } else {
                Toast.makeText(loginActivity.this, "Gagal Login, ID atau Password Salah", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
