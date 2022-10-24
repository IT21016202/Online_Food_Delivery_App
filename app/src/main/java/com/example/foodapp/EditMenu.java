package com.example.foodapp;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;








    public class EditMenu extends AppCompatActivity {

        private Button menuButton;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_edit_menu);


            menuButton = (Button) findViewById(R.id.btn1);
            menuButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openMenuPage();
                }
            });
        }


        public void openMenuPage(){
            Intent intent = new Intent(this, MainMenu.class);
            startActivity(intent);
        }



    }


