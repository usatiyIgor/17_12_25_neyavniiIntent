package com.example.den.a17_12_25_neyavniiintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
    String keyAction;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        TextView nameTxt = findViewById(R.id.name);
        TextView phoneTxt = findViewById(R.id.phone);
        TextView emailTxt = findViewById(R.id.email);
        Intent intent = getIntent();

        if(intent.getAction().contains("name")){
            data = intent.getExtras().getString("NAME");
            keyAction = "NAME";
            nameTxt.setText(data);
            nameTxt.setVisibility(View.VISIBLE);
        }else if(intent.getAction().contains("phone")){
            data =intent.getExtras().getString("PHONE");
            keyAction = "PHONE";
            phoneTxt.setText(data);
            phoneTxt.setVisibility(View.VISIBLE);
        }else if(intent.getAction().contains("email")){
            data = intent.getExtras().getString("EMAIL");
            keyAction = "EMAIL";
            emailTxt.setText(data);
            emailTxt.setVisibility(View.VISIBLE);
        }
        Button okBtn = findViewById(R.id.ok_btn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMain = new Intent("telran.java17.main.action");
                intentMain.putExtra("ACTION",keyAction);
                intentMain.putExtra("DATA",data);
                startActivity(intentMain);
            }
        });
    }
}
