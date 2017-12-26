package com.example.den.a17_12_25_neyavniiintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText inputName, inputPhone, inputEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputName = findViewById(R.id.input_name);
        inputPhone = findViewById(R.id.input_phone);
        inputEmail = findViewById(R.id.input_email);
        Button setName = findViewById(R.id.setname);
        setName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("telran.java17.name.action");
                intent.putExtra("NAME", inputName.getText().toString());
                startActivity(intent);
            }
        });
        Button setPhone = findViewById(R.id.setphone);
        setPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("telran.java17.phone.action");
                intent.putExtra("PHONE", inputPhone.getText().toString());
                startActivity(intent);
            }
        });
        Button setEmail = findViewById(R.id.setemail);
        setEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("telran.java17.email.action");
                intent.putExtra("EMAIL", inputEmail.getText().toString());
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            switch (intent.getExtras().getString("ACTION", "DEF")) {
                case "NAME":
                    inputName.setText(intent.getExtras().getString("DATA"));
                    break;
                case "PHONE":
                    inputPhone.setText(intent.getExtras().getString("DATA"));
                    break;
                case "EMAIL":
                    inputEmail.setText(intent.getExtras().getString("DATA"));
                    break;
                case "DEF":
                    break;
            }
        }
    }
}