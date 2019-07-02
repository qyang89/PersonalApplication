package com.example.personalapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Page4Review extends AppCompatActivity {

    //define variables for this page

   EditText firstName, lastName, dob, aboutMe, favoritePet;
    private Button toPage3;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_display);

        toPage3 = findViewById(R.id.toPage3);

        toPage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();   //returning to page 3, no other action
            }
        });




        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        dob = findViewById(R.id.dob);
        aboutMe = findViewById(R.id.aboutMe);
        favoritePet = findViewById(R.id.favoritePet);

        sharedPreferences = getSharedPreferences("Form", MODE_PRIVATE);

//retreiving saved info from previous pages
        firstName.setText(sharedPreferences.getString("firstName",""));

        lastName.setText(sharedPreferences.getString("lastName",""));

        dob.setText(sharedPreferences.getString("dob",""));

        aboutMe.setText(sharedPreferences.getString("aboutMe",""));

        favoritePet.setText(sharedPreferences.getString("favoritePet",""));
    }

    @Override
    protected void onResume() {
        super.onResume();

//returns page 4 info
        sharedPreferences = getSharedPreferences("Form", MODE_PRIVATE);
        favoritePet.setText(sharedPreferences.getString("favoritePet", ""));
        aboutMe.setText(sharedPreferences.getString("aboutMe", ""));
        dob.setText(sharedPreferences.getString("dob", ""));
        firstName.setText(sharedPreferences.getString("firstName", ""));
        lastName.setText(sharedPreferences.getString("lastName", ""));
    }

    @Override
    protected void onPause() {
        super.onPause();

        //returns page 4 info
        sharedPreferences = getSharedPreferences("Form", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("favoritePet", favoritePet.getText().toString());
        editor.putString("aboutMe", aboutMe.getText().toString());
        editor.putString("dob", dob.getText().toString());
        editor.putString("firstName", firstName.getText().toString());
        editor.putString("lastName", lastName.getText().toString());
        editor.apply();
    }

}
