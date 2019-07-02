package com.example.personalapplication;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Page3 extends AppCompatActivity{

    private Button toPage4;
    private Button toPage2;
    private EditText favoritePet;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form3_activity);

        toPage2 = findViewById(R.id.toPage2);
        toPage4 = findViewById(R.id.toPage4);
        favoritePet = (EditText) findViewById(R.id.favoritePet);

        toPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();   //returning to page 2, no other action
            }
        });


        //saves and passes page3 information to going to page4
        toPage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Page4Review.class);
                sharedPreferences = getSharedPreferences("Form", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("favoritePet", favoritePet.getText().toString());
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

//returns page 3 info
        sharedPreferences = getSharedPreferences("Form", MODE_PRIVATE);
        favoritePet.setText(sharedPreferences.getString("favoritePet", ""));
    }

    @Override
    protected void onPause() {
        super.onPause();

        //returns page 3 info
        sharedPreferences = getSharedPreferences("Form", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("favoritePet", favoritePet.getText().toString());
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


