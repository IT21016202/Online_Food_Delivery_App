package com.example.foodapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class enrolment extends AppCompatActivity {

    private Button submitBtn;
    private Button canclOdrBtn;
    private EditText name, phone, address;
    private Context context;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrolment);

        name = findViewById(R.id.name_txt);
        phone = findViewById(R.id.phone_txt);
        address = findViewById(R.id.address_txt);
        submitBtn = findViewById(R.id.btnSubmit1);
        context = this;

        dbHandler = new DBHandler(context);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Userphone = phone.getText().toString();
                String Username = name.getText().toString();
                String Useraddress = address.getText().toString();

                Enrol enrol = new Enrol(Integer.parseInt(Userphone), Username, Useraddress);
                dbHandler.addEnrol(enrol);

                startActivity(new Intent(context,order_summary.class ));
            }
        });

//        submitBtn = (Button) findViewById(R.id.btnSubmit1);
//        submitBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openOdrSummry();
//            }
//        });

        canclOdrBtn = (Button) findViewById(R.id.btncanclOdr1);
        canclOdrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMain();
            }
        });
    }

    private void openMain() {
        Intent intent = new Intent(this, Order_Details.class);
        startActivity(intent);
    }

//    private void openOdrSummry() {
//        Intent intent = new Intent(this, order_summary.class);
//        startActivity(intent);
//    }
}