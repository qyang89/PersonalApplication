package com.example.personalapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Page1 extends AppCompatActivity {


    //variables on Page 1
   private Button toPage2;  //this is the "next" button to page2
   private EditText firstName, lastName, dob;  //these are the text fields

    SharedPreferences sharedPreferences;  //define sharedpreference for saving

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form1_activity);  //view this xml layout


        toPage2 = findViewById(R.id.toPage2);     //these are the button/fields that are passed
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        dob = (EditText) findViewById(R.id.dob);


        toPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {  //when next to page 2 is clicked, page 1 saves and is passed
                Intent intent = new Intent(getApplicationContext(), Page2.class);
                sharedPreferences = getSharedPreferences("Form", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("firstName", firstName.getText().toString());
                editor.putString("lastName", lastName.getText().toString());
                editor.putString("dob", dob.getText().toString());
                editor.apply();
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

//information is saved and retrievabled
        sharedPreferences = getSharedPreferences("Form", MODE_PRIVATE);
        firstName.setText(sharedPreferences.getString("firstName", ""));
        lastName.setText(sharedPreferences.getString("lastName", ""));
        dob.setText(sharedPreferences.getString("dob", ""));

    }

    @Override
    protected void onPause() {
        super.onPause();

        //information is saved and retrievabled
        sharedPreferences = getSharedPreferences("Form", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("firstName", firstName.getText().toString());
        editor.putString("lastName", lastName.getText().toString());
        editor.putString("dob", dob.getText().toString());
        editor.apply();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
