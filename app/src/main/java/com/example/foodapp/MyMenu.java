package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;


public class MyMenu extends AppCompatActivity {
        private Button editButton;
        private Button addButton;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_my_menu);

            editButton = (Button) findViewById(R.id.button);
            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openEditPage();

                }
            });
            editButton = (Button) findViewById(R.id.button3);
            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openEditPage2();

                }
            });


            addButton = (Button) findViewById(R.id.btnNew);
            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openAddPage();
                }
            });
        }


        public void openAddPage() {
            Intent intent = new Intent(this, AddMenu.class);
            startActivity(intent);
        }


        public void openEditPage() {
            Intent intent = new Intent(this, EditMenu.class);
            startActivity(intent);
        }

        public void openEditPage2() {
            Intent intent = new Intent(this, EditMenu.class);
            startActivity(intent);

        }
    }

