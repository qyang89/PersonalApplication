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

public class Page2 extends AppCompatActivity {


    private Button toPage1;
    private Button toPage3;
    private EditText aboutMe;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form2_activity);

        toPage1 = findViewById(R.id.toPage1);
        toPage3 = findViewById(R.id.toPage3);
        aboutMe = (EditText) findViewById(R.id.aboutMe);


        toPage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();   //returning to page 1, no other action
            }
        });

        toPage3.setOnClickListener(new View.OnClickListener() {   //clicking on next to page 3 will save and pass this page 2's information
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Page3.class);
                sharedPreferences = getSharedPreferences("Form", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("aboutMe", aboutMe.getText().toString());
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
//returns to page 2 info
        sharedPreferences = getSharedPreferences("Form", MODE_PRIVATE);
        aboutMe.setText(sharedPreferences.getString("aboutMe", ""));
    }


    @Override
    protected void onPause() {
        super.onPause();
//returns to page 2 info
        sharedPreferences = getSharedPreferences("Form", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("aboutMe", aboutMe.getText().toString());
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


